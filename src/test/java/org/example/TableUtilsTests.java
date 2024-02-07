package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TableUtilsTests {
    @Nested
    public class CreateTable {
        @Test
        public void shouldCreateTableWhenSomeCellsAreEmpty() {
            List<String> list = new ArrayList<>();
            list.add("hello\t123");
            list.add("");
            list.add("world\tblabla\ttest");

            String[][] expected = {
                    {"hello", "123", null},
                    {"", null, null},
                    {"world", "blabla", "test"}
            };

            Assertions.assertArrayEquals(expected, TableUtils.createTable(list));
        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortTableWhenSomeCellsAreEmpty() {
            String[][] table = {
                    {"hello", "123", null},
                    {"", null, null},
                    {"world", "blabla", "test test"},
                    {"world", "blabla", "test"}
            };

            String[][] expected = {
                    {"", null, null},
                    {"hello", "123", null},
                    {"world", "blabla", "test"},
                    {"world", "blabla", "test test"}
            };

            Assertions.assertArrayEquals(expected, TableUtils.sort(table));
        }
    }
}
