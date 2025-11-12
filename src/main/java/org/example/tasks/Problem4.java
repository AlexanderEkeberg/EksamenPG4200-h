package org.example.tasks;

import java.util.List;

public class Problem4 {
    public enum Pivot {
        FIRST, LAST, RANDOM
    }

    private static long comparisons;

    public static void sort(List<Double> a, Pivot pv, java.util.Random rng) {
        comparisons = 0;
        if (a == null || a.size() < 2) return;
        if (rng == null) rng = new java.util.Random();
        quick(a, 0, a.size() - 1, pv, rng);
    }

    public static void sort(List<Double> a) {
        sort(a, Pivot.FIRST, new java.util.Random());
    }

    private static void quick(List<Double> a, int lo, int hi, Pivot pv, java.util.Random rng) {
        if (lo >= hi) return;
        choosePivot(a, lo, hi, pv, rng);
        int p = partition(a, lo, hi);
        quick(a, lo, p - 1, pv, rng);
        quick(a, p + 1, hi, pv, rng);
    }

    private static void choosePivot(List<Double> a, int lo, int hi, Pivot pv, java.util.Random rng) {
        switch (pv) {
            case FIRST -> swap(a, lo, hi);
            case LAST  -> { }
            case RANDOM -> swap(a, lo + rng.nextInt(hi - lo + 1), hi);
        }
    }

    private static int partition(List<Double> a, int lo, int hi) {
        double pivot = a.get(hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            comparisons++;
            if (a.get(j) <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private static void swap(List<Double> a, int i, int j) {
        if (i == j) return;
        Double t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    public static long getComparisons() {
        return comparisons;
    }
}