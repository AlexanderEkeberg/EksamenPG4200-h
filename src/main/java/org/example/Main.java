package org.example;

import org.example.readFiles.ReadCsvFiles;
import org.example.tasks.Problem1;
import org.example.tasks.Problem2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Double> alcoholValues = ReadCsvFiles.getAllAlcoholValues();
        List<Double> insert = ReadCsvFiles.getAllAlcoholValues();
        System.out.println("\n=== After Bubble Sort ===");

        long start = System.nanoTime();
        Problem1.bubbleSortNonOptimized(alcoholValues);
        long end = System.nanoTime();

        System.out.println(Arrays.toString(alcoholValues.toArray()));
        double timeMs = (end - start) / 1_000_000.0;
        System.out.printf("Bubble sort took %.3f ms%n", timeMs);

        // === Problem 2: Insertion Sort ===
        System.out.println("\n=== After Insertion Sort ===");

        long start2 = System.nanoTime();
        Problem2.insertionSort(insert);
        long end2 = System.nanoTime();

        System.out.println(Arrays.toString(insert.toArray()));
        double timeMs2 = (end2 - start2) / 1_000_000.0;
        System.out.printf("Insertion sort took %.3f ms%n", timeMs2);

        // problem 3

        // problem 4



    }
}