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

        // problem 1
        Problem1.bubbleSort(alcoholValues);

        System.out.println("\n=== Etter sortering ===");
        System.out.println(Arrays.toString(alcoholValues.toArray()));

        // problem 2
        alcoholValues = ReadCsvFiles.getAllAlcoholValues();
        Problem2.insertionSort(alcoholValues);
        System.out.println("\n=== After Insertion Sort ===");
        System.out.println(Arrays.toString(alcoholValues.toArray()));

        // problem 3

        // problem 4



    }
}