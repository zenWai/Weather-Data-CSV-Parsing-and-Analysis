package main.java.com.presa;

import lib.csv.CSVRecord;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeatherDataParser parser = new WeatherDataParser();
        WeatherAnalyzer analyzer = new WeatherAnalyzer();
        WeatherConsoleReporter reporter = new WeatherConsoleReporter();

        List<CSVRecord> records = parser.parseFiles();
        CSVRecord hottestRecord = analyzer.getRecordWithHighestTemperature(records);
        CSVRecord coldestRecord = analyzer.getRecordWithColdestTemperature(records);
        double averageTemperature = analyzer.getAverageTemperature(records);
        CSVRecord lowestHumidityRecord = analyzer.getRecordWithLowestHumidity(records);
        CSVRecord highestHumidityRecord = analyzer.getRecordWithHighestHumidity(records);
        //will get avg of temperatures when humidity higher than HUMIDITY
        int HUMIDITY = 80;
        double avgTempWithHighHumidity = analyzer.getAverageTemperatureWhenHumidityIsHigh(records, HUMIDITY);


        reporter.reportHottestTemperature(hottestRecord);
        reporter.reportColdestTemperature(coldestRecord);
        reporter.reportLowestHumidity(lowestHumidityRecord);
        reporter.reportHigherHumidity(highestHumidityRecord);
        reporter.reportAverageTemperatureInFile(averageTemperature);
        reporter.reportAverageTemperatureWithHighHumidity(avgTempWithHighHumidity, HUMIDITY);
    }
}
