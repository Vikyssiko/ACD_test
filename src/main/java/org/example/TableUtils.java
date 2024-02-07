package org.example;

import java.util.List;

public class TableUtils {
    private static int findRowLength(List<String> rows) {
        int length = 0;
        for (String row : rows) {
            length = Math.max(row.split("\t").length, length);
        }
        return length;
    }

    public static String[][] createTable(List<String> list) {
        int length = findRowLength(list);
        int i = 0;
        String[][] table = new String[list.size()][length];
        for (String row : list) {
            String[] cells = row.split("\t");
            System.arraycopy(cells, 0, table[i], 0, cells.length);
            i++;
        }
        return table;
    }

    private static int compareCells(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return -1;
        }
        if (s2 == null) {
            return 1;
        }
        try {
            Double d1 = Double.parseDouble(s1);
            try {
                Double d2 = Double.parseDouble(s2);
                return d1.compareTo(d2);
            } catch (NumberFormatException d2FormatException) {
                return -1;
            }
        } catch (NumberFormatException d1FormatException) {
            try {
                Double.parseDouble(s2);
                return 1;
            } catch (NumberFormatException d2FormatException) {
                return s1.compareTo(s2);
            }
        }
    }

    private static int compareRows(String[] cell, String[] compared) {
        int compareResult;
        for (int i = 0; i < compared.length; i++) {
            compareResult = compareCells(cell[i], compared[i]);
            if (compareResult != 0)
                return compareResult;
        }
        return 0;
    }

    public static String[][] sort(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            String[] temp;
            for (int j = 0; j < table.length - 1; j++) {
                if (compareRows(table[j], table[j + 1]) > 0) {
                    temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                }
            }
        }
        return table;
    }
}
