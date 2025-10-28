package org.example.readFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFiles {

    private static List<Double> readAlcoholColumn(String filename) throws IOException {
        List<Double> values = new ArrayList<>();

        try (InputStream is = ReadCsvFiles.class.getResourceAsStream("/" + filename)) {
            if (is == null) {
                throw new IOException("Fant ikke filen: " + filename);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String header = br.readLine();
                if (header == null) return values;

                String[] cols = header.split(";");
                int alcoholIndex = -1;


                for (int i = 0; i < cols.length; i++) {
                    if (cols[i].replace("\"", "").trim().toLowerCase().contains("alcohol")) {
                        alcoholIndex = i;
                        break;
                    }
                }

                if (alcoholIndex == -1) {
                    throw new IOException("Fant ikke kolonnen 'alcohol' i " + filename);
                }

                // Les data
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length > alcoholIndex) {
                        String value = parts[alcoholIndex].replace(',', '.').trim();
                        if (!value.isEmpty()) {
                            try {
                                values.add(Double.parseDouble(value));
                            } catch (NumberFormatException ignored) {
                                // Hopper over ugyldige tall
                            }
                        }
                    }
                }
            }
        }

        return values;
    }


    public static List<Double> getAllAlcoholValues() throws IOException {
        List<Double> all = new ArrayList<>();
        all.addAll(readAlcoholColumn("winequality-red.csv"));
        all.addAll(readAlcoholColumn("winequality-white.csv"));
        return all;
    }
}