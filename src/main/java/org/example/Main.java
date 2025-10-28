package org.example;

import org.example.readFiles.ReadCsvFiles;
import org.example.tasks.Problem1;
import org.example.tasks.Problem2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Double> alcoholValues = ReadCsvFiles.getAllAlcoholValues();

        List<Double> opt = new ArrayList<>(alcoholValues);
        List<Double> nonOpt = new ArrayList<>(alcoholValues);
        List<Double> insert = new ArrayList<>(alcoholValues);

        // Problem 1a
        long start = System.nanoTime();
        Problem1.bubbleSortOptimized(opt);
        long end = System.nanoTime();
        System.out.println("\n=== Optimized Bubble Sort ===");
        System.out.println(opt);
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // Problem 1b
        start = System.nanoTime();
        Problem1.bubbleSortNonOptimized(nonOpt);
        end = System.nanoTime();
        System.out.println("\n=== Non-Optimized Bubble Sort ===");
        System.out.println(nonOpt);
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // Problem 2
        start = System.nanoTime();
        Problem2.insertionSort(insert);
        end = System.nanoTime();
        System.out.println("\n=== Insertion Sort ===");
        System.out.println(insert);
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");

        // problem 3

        // problem 4



    }
}