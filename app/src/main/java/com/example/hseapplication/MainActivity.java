package com.example.hseapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hseapplication.algo.DelphiMethod;
import com.example.hseapplication.algo.MedianCounter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ru.hse.protobuf.ClientRequest;
import ru.hse.protobuf.HandlerServiceGrpc;
import ru.hse.protobuf.ServerResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String HOST = "192.168.1.69";
    public static final int PORT = 9091;

    private static final String TAG = "MainActivity";
    Button mainButton;
    EditText markField;
    EditText commentField;
    TextView infoTextView;
    TextView expertQuestion;
    TextView expertComments;
    ManagedChannel channel;
    HandlerServiceGrpc.HandlerServiceStub handlerService;
    static StreamObserver<ClientRequest> chat;

    private static int n;
    private static final String ID = UUID.randomUUID().toString();
    private static ConcurrentHashMap<String, ServerResponse> map = new ConcurrentHashMap<>();

    // 1 - vote, 2 - comment, 3 - done
    private static int status;

    private static Comparator<ServerResponse> comparator = (a, b) -> {
        double a1 = Double.parseDouble(a.getMark());
        double b1 = Double.parseDouble(b.getMark());
        if (a1 > b1) {
            return 1;
        } else if (a1 < b1) {
            return -1;
        }
        return 0;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findGuiElements();
    }

    void findGuiElements() {
        mainButton = findViewById(R.id.mainButton);
        markField = findViewById(R.id.markField);
        commentField = findViewById(R.id.commentField);
        expertQuestion = findViewById(R.id.expertQuestion);
        expertComments = findViewById(R.id.expertComments);
        infoTextView = findViewById(R.id.infoField);
        mainButton.setOnClickListener(this);
        infoTextView.setText("Нажмите на кнопку, чтобы участвовать в голосовании");
        commentField.setEnabled(false);
        expertQuestion.setEnabled(false);
        expertComments.setEnabled(false);
        markField.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        if (mainButton == v) {
            Log.i(TAG, "Button pressed!");
            if (status == 0) {
                //Toast.makeText(this, "Поиск сервера для голосования", Toast.LENGTH_SHORT).show();
                openService(v);
                startService();
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                }
                ClientRequest requestGrpc = getClientRequest("-1", "-1");
                chat.onNext(requestGrpc);
            } else if (status == 1) {
                ClientRequest requestGrpc = getClientRequest("-1", markField.getText().toString());
                chat.onNext(requestGrpc);
                mainButton.setEnabled(false);
                markField.setText("");
                markField.setEnabled(false);
            } else if (status == 2) {
                ClientRequest requestGrpc = getClientRequest(commentField.getText().toString(), "-1");
                chat.onNext(requestGrpc);
                commentField.setText("");
                commentField.setEnabled(false);
                // status = 1; //////////
            } else if (status == 3) {
                status = 0;
                n = -1;
                DelphiMethod.setK0(-1);
                chat.onCompleted();
                mainButton.setText("Участвовать");
                infoTextView.setText("Нажмите на кнопку, чтобы участвовать в голосовании");
                expertComments.setText("");
                markField.setText("");
            }
        }
    }

    private ClientRequest getClientRequest(String description, String mark) {
        return ClientRequest.newBuilder()
                .setId(ID)
                .setMark(mark)
                .setDescription(description)
                .build();
    }

    public void openService(View view) {
        channel = ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build();
    }

    public void exitService(View view) {
        channel.shutdown();
        mainButton.setEnabled(true);
        mainButton.setText("Участвовать");
        Toast.makeText(this, "Канал связи закрыт", Toast.LENGTH_SHORT).show();
    }

    public void startService() {
        if (handlerService == null) {
            handlerService = HandlerServiceGrpc.newStub(channel);
            Log.i(TAG, "Handler service init");
        }
        new GrpcTask(this, handlerService).execute();
    }

    private class GrpcTask extends AsyncTask<Void, Void, String> {

        private final WeakReference<MainActivity> activityReference;
        private final WeakReference<HandlerServiceGrpc.HandlerServiceStub> handlerServiceReference;
        private AtomicInteger counter = new AtomicInteger(0); // 0

        GrpcTask(MainActivity activityReference, HandlerServiceGrpc.HandlerServiceStub handlerServiceReference) {
            this.activityReference = new WeakReference<>(activityReference);
            this.handlerServiceReference = new WeakReference<>(handlerServiceReference);
        }

        @Override
        protected String doInBackground(Void... nothing) {
            try {
                /*if (handlerServiceReference.get() == null) {
                    handlerServiceReference = HandlerServiceGrpc.newStub(channel);
                    Log.i(TAG, "Handler service init");
                }*/
                chat = handlerServiceReference.get().handleRequest(new StreamObserver<ServerResponse>() {
                    @Override
                    public void onNext(ServerResponse value) {
                        Log.i(TAG, "Message from server: " + value);
                        String action = value.getAction();
                        if (action.startsWith("Wait:")) {
                            n = Integer.parseInt(action.substring(action.indexOf(":") + 1)); //// + 2
                            /*map.put("1", ServerResponse.newBuilder()
                                    .setMark("5")
                                    .build());
                            map.put("2", ServerResponse.newBuilder()
                                    .setMark("6")
                                    .build());*/
                            Log.i(TAG, "Question for experts: " + value.getComments());
                            runOnUiThread(() -> {
                                infoTextView.setText("Экспертов в голосовании: " + n);
                                mainButton.setEnabled(false);
                                activityReference.get().expertQuestion.setText(value.getComments());
                            });
                            // Toast.makeText(null, "Клиент подключен. Всего экспертов: " + n, Toast.LENGTH_SHORT).show();

                        } else if (action.equals("Vote")) {
                            Log.i(TAG, "Vote: " + value);
                            runOnUiThread(() -> {
                                activityReference.get().infoTextView.setText("Начался процесс голосования");
                                activityReference.get().mainButton.setText("Голосовать");
                                activityReference.get().mainButton.setEnabled(true);
                                activityReference.get().markField.setEnabled(true);
                            });
                            status = 1;
                        } else if (action.equals("Mark")) {
                            Log.i(TAG, "Mark received. Value: " + value);
                            map.put(value.getId(), value);

                            // Мапа накполнена и можно делать анализ
                            if (map.size() == n) {
                                Log.i(TAG, "Vote done. Result map: " + map);
                                double[] marks = getMarksFromMap();
                                if (DelphiMethod.getK0() == -1) {
                                    DelphiMethod.setInitQuantile(n, marks);
                                    defineCommentGroup();
                                    map.clear(); ///////
                                   /* map.put("1", ServerResponse.newBuilder()
                                            .setMark("5")
                                            .build());
                                    map.put("2", ServerResponse.newBuilder()
                                            .setMark("6")
                                            .build());*/
                                } else {
                                    double k = DelphiMethod.getQuantile(n, marks);
                                    if (DelphiMethod.quantileIsNotThreshold(k)) {
                                        defineCommentGroup();
                                        map.clear(); /////
                                        /*map.put("1", ServerResponse.newBuilder()
                                                .setMark("5")
                                                .build());
                                        map.put("2", ServerResponse.newBuilder()
                                                .setMark("6")
                                                .build());*/
                                    } else {
                                        Log.i(TAG, "**** MEDIAN MARK IS:  " + MedianCounter.countMedian(marks));
                                        runOnUiThread(() -> {
                                            activityReference.get().infoTextView.setText("MEDIAN MARK IS:  " + MedianCounter.countMedian(marks));
                                            activityReference.get().mainButton.setText("Завершить");
                                            activityReference.get().mainButton.setEnabled(true);
                                            activityReference.get().expertQuestion.setText("");
                                        });
                                        status = 3;
                                    }
                                }
                            }
                        } else if (action.equals("Comment")) {
                            Log.i(TAG, "Comment received. Value: " + value);
                            runOnUiThread(() -> activityReference.get().expertComments.setText(activityReference.get().expertComments.getText().toString() + "\n" + value.getComments()));
                            if (counter.incrementAndGet() == n / 2) { // проверить с вот этой правкой завтра
                                counter.set(0); // 0
                                status = 1;
                                Log.i(TAG, "Vote again");
                                runOnUiThread(() -> {
                                    activityReference.get().infoTextView.setText("Начался процесс голосования");
                                    activityReference.get().mainButton.setText("Голосовать");
                                    activityReference.get().mainButton.setEnabled(true);
                                    activityReference.get().markField.setEnabled(true);
                                });
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.err.println("Some error occured: " + t);
                    }

                    @Override
                    public void onCompleted() {
                        System.err.println("done");
                        status = 0;
                        n = -1;
                        DelphiMethod.setK0(-1);
                        chat.onCompleted();
                        runOnUiThread(() -> {
                            activityReference.get().mainButton.setText("Участвовать");
                            activityReference.get().infoTextView.setText("Нажмите на кнопку, чтобы участвовать в голосовании");
                            activityReference.get().expertComments.setText("");
                            activityReference.get().markField.setText("");
                        });
                    }
                });
                return "Success";
            } catch (Exception ex) {
                return "Error";
            }
        }

        private void defineCommentGroup() {
            List<ServerResponse> list = new ArrayList<>(map.values());
            Collections.sort(list, comparator);
            int groupSize = n / 4;
            for (int i = 0; i < groupSize; i++) {
                if (list.get(i).getId().equals(ID)) {
                    status = 2;
                    Log.i(TAG, "Please enter your comment -> ");
                    runOnUiThread(() -> {
                        activityReference.get().mainButton.setEnabled(true);
                        activityReference.get().infoTextView.setText("Введите свой комментарий");
                        activityReference.get().mainButton.setText("Комментировать");
                        activityReference.get().commentField.setEnabled(true);
                    });
                    break;
                }
            }

            for (int i = 3 * groupSize; i < n; i++) {
                if (list.get(i).getId().equals(ID)) {
                    status = 2;
                    Log.i(TAG, "Please enter your comment -> ");
                    runOnUiThread(() -> {
                        activityReference.get().mainButton.setEnabled(true);
                        activityReference.get().infoTextView.setText("Введите свой комментарий");
                        activityReference.get().mainButton.setText("Комментировать");
                        activityReference.get().commentField.setEnabled(true);
                    });
                    break;
                }
            }
        }

        private double[] getMarksFromMap() {
            double[] marks = new double[n];
            int i = 0;
            for (ServerResponse response : map.values()) {
                marks[i] = Double.parseDouble(response.getMark());
                i++;
            }
            return marks;
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }

}
