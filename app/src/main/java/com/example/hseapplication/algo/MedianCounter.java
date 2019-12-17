package com.example.hseapplication.algo;

import java.util.Arrays;

public class MedianCounter {

    public static double countMedian(double[] elements) {
        Arrays.sort(elements);
        int length = elements.length;
        if (length % 2 == 0)
            return ((elements[length / 2] + elements[length / 2 - 1]) / 2.0);
        return elements[length / 2];
    }

}
