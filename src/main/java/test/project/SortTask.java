package test.project;

import java.util.*;

public class SortTask {
    public static void main(String[] args) {
        List<String> rows = FileUtils.readFile("in.txt");
        if (rows != null) {
            String[][] table = TableUtils.createTable(rows);
            FileUtils.writeTableToFile("out.txt", TableUtils.sort(table));
        }
    }
}