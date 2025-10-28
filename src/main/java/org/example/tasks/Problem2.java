package org.example.tasks;

import java.util.List;

public class Problem2 {

    public static void insertionSort(List<Double> arr) {
        int n = arr.size();

        for (int i = 1; i < n; i++) {
            double key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);
        }
    }
}
