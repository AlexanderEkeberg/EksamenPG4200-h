package org.example.tasks;

import java.util.List;

public class Problem3 {

    public static long mergeOps = 0;

    static void merge(double[] arr, int l, int m, int r) {
        mergeOps++; // count merge operation

        int n1 = m - l + 1;
        int n2 = r - m;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void mergeSort(double[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Wrapper for List<Double>
    public static void mergeSort(List<Double> list) {
        mergeOps = 0; // reset count
        double[] a = list.stream().mapToDouble(Double::doubleValue).toArray();
        if (a.length > 0) mergeSort(a, 0, a.length - 1);
        list.clear();
        for (double v : a) list.add(v);
    }
}
