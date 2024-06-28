package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilter {

    public static void main(String[] args) {
        // Example usage
        String filePath = "/home/omkar/Desktop/Assignments/Data Storage assign/data.csv";
        FilterCondition filterCondition = new FilterCondition("column_name", "John");

        try {
            List<CSVRecord> filteredRecords = filterCsv(filePath, filterCondition);
            // Print or process filteredRecords as needed
            for (CSVRecord record : filteredRecords) {
                System.out.println(record.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CSVRecord> filterCsv(String filePath, FilterCondition filterCondition) throws IOException {
        List<CSVRecord> records = parseCsv(filePath);
        List<CSVRecord> filteredRecords = new ArrayList<>();

        for (CSVRecord record : records) {
            if (matchesFilter(record, filterCondition)) {
                filteredRecords.add(record);
            }
        }

        return filteredRecords;
    }

    private static List<CSVRecord> parseCsv(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        return csvParser.getRecords();
    }

    private static boolean matchesFilter(CSVRecord record, FilterCondition filterCondition) {
        // Implement your filtering logic based on the FilterCondition
        // Example: Compare record values with FilterCondition criteria
        String columnValue = record.get(filterCondition.getColumnName());
        return columnValue.equals(filterCondition.getValue());
    }

    // Example of a FilterCondition class
    static class FilterCondition {
        private String columnName;
        private String value;

        public FilterCondition(String columnName, String value) {
            this.columnName = columnName;
            this.value = value;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getValue() {
            return value;
        }
    }
}

