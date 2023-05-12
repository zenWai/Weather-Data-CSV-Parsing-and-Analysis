package main.java.com.presa;

import lib.csv.CSVParser;
import lib.csv.CSVRecord;
import lib.duke.DirectoryResource;
import lib.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeatherDataParser {

    public List<CSVRecord> parseFiles() {
        List<CSVRecord> records = new ArrayList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord record : parser) {
                records.add(record);
            }
        }
        return records;
    }
}
