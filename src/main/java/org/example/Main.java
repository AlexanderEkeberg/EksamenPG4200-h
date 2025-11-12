package org.example;

import org.example.readFiles.ReadCsvFiles;
import org.example.tasks.Problem1;
import org.example.tasks.Problem2;
import org.example.tasks.Problem3;
import org.example.tasks.Problem4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Double> alcoholValues = ReadCsvFiles.getAllAlcoholValues();

// Use UNIQUE alcohol values first (as required)
        List<Double> base = alcoholValues.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        List<Double> opt = new ArrayList<>(base);
        List<Double> nonOpt = new ArrayList<>(base);
        List<Double> insert = new ArrayList<>(base);
        List<Double> merge = new ArrayList<>(base);
        List<Double> qSFirst = new ArrayList<>(base);
        List<Double> qSLast = new ArrayList<>(base);
        List<Double> qSRandom = new ArrayList<>(base);

        // Problem 1a
        long start = System.nanoTime();
        Problem1.bubbleSortOptimized(opt);
        long end = System.nanoTime();
        System.out.println("\n=== Optimized Bubble Sort ===");
        System.out.println(opt.stream().limit(10).toList());
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // Problem 1b
        start = System.nanoTime();
        Problem1.bubbleSortNonOptimized(nonOpt);
        end = System.nanoTime();
        System.out.println("\n=== Non-Optimized Bubble Sort ===");
        System.out.println(nonOpt.stream().limit(10).toList());

        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // Problem 2
        start = System.nanoTime();
        Problem2.insertionSort(insert);
        end = System.nanoTime();
        System.out.println("\n=== Insertion Sort ===");
        System.out.println(insert.stream().limit(10).toList());
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // problem 3
        Problem3.mergeSort(merge);

        System.out.println("\n=== Merge Sort ===");
        System.out.println(merge.stream().limit(10).toList());
        System.out.println("Number of merge operations: " + Problem3.mergeOps);

        // problem 4a
        System.out.println("\n=== Quick Sort ===");

        System.out.println("\n=== Quick Sort First ===");
        Problem4.sort(qSFirst, Problem4.Pivot.FIRST, null);
        System.out.println("First element: " + qSFirst.getFirst());
        System.out.println("Comparisons: " + Problem4.getComparisons());

        System.out.println("\n=== Quick Sort Last ===");
        Problem4.sort(qSLast, Problem4.Pivot.LAST, null);
        System.out.println("Last element: " + qSLast.getLast());
        System.out.println("Comparisons: " + Problem4.getComparisons());

        System.out.println("\n=== Quick Sort Random ===");
        Random r = new Random(42);
        Problem4.sort(qSRandom, Problem4.Pivot.RANDOM, r);
        System.out.println("Random element: " + qSRandom.get(r.nextInt(qSRandom.size())));
        System.out.println("Comparisons: " + Problem4.getComparisons());

    }
}