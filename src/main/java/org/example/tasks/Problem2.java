package org.example.tasks;

import java.util.List;

public class Problem2 {

    // Insertion Sort algorithm that works on a List<Double>
    public static void insertionSort(List<Double> arr) {
        int n = arr.size();

        for (int i = 1; i < n; i++) {
            double key = arr.get(i);
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);
        }
    }
}
