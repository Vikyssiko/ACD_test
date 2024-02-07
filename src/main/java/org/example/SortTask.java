package org.example;

import java.io.*;
import java.util.*;

public class SortTask {
    public static void main(String[] args) {
        List<String> rows = readFile("in.txt");
        if (rows != null) {
            String[][] table = TableUtils.createTable(rows);
            writeTableToFile("out.txt", TableUtils.sort(table));
        }
    }

    private static List<String> readFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            ArrayList<String> rows = new ArrayList<>();
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                rows.add(str);
                str = reader.readLine();
            }
            return rows;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(file.getAbsolutePath() + " - File is not found.");
            return null;
        } catch (IOException ioException) {
            System.out.println(file.getAbsolutePath() + " - Error");
            return null;
        }
    }

    private static void writeTableToFile(String fileName, String[][] table) {
        File file = new File(fileName);
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
            for (String[] rows : table) {
                for (String cell : rows) {
                    if (cell != null) {
                        System.out.print(cell);
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
            System.out.flush();
            System.setOut(console);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.flush();
            System.setOut(console);
            System.out.println(file.getAbsolutePath() + " - File is not found.");
        }
    }
}