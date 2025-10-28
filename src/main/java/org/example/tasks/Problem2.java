package org.example.tasks;

import org.example.readFiles.ReadCsvFiles;
import java.io.IOException;
import java.util.List;

public class Problem2 {

    public void sort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.println(v);
        }
    }

    public static void execute() {
        try {
            List<Double> alcoholList = ReadCsvFiles.getAllAlcoholValues();

            double[] alcoholArray = alcoholList.stream().mapToDouble(Double::doubleValue).toArray();

            Problem2 sorter = new Problem2();
            sorter.sort(alcoholArray);

            System.out.println("Sorted alcohol content values: ");
            printArray(alcoholArray);

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
