package main.java.com.presa;

import lib.csv.CSVRecord;

import java.util.List;

public class WeatherAnalyzer {
    private final WeatherDataAnalyticHelpers dataHelper;
    public WeatherAnalyzer() {
        this.dataHelper =new WeatherDataAnalyticHelpers();
    }

    public CSVRecord getRecordWithHighestTemperature(List<CSVRecord> records) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : records) {
            largestSoFar = dataHelper.getLargestTemperatureOfTwoRecords(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public CSVRecord getRecordWithColdestTemperature(List<CSVRecord> records) {
        CSVRecord coldestSoFar = null;
        for ( CSVRecord currentRow : records ) {
            coldestSoFar = dataHelper.getLowerTemperatureOfTwoRecords(currentRow, coldestSoFar);
        }
        return coldestSoFar;
    }

    public CSVRecord getRecordWithLowestHumidity(List<CSVRecord> records) {
        CSVRecord lowestHumidity = null;
        for ( CSVRecord currentRow : records ) {
            lowestHumidity = dataHelper.getLowerHumidityOfTwoRecords(currentRow, lowestHumidity);
        }
        return lowestHumidity;
    }

    public CSVRecord getRecordWithHighestHumidity(List<CSVRecord> records) {
        CSVRecord lowestHumidity = null;
        for ( CSVRecord currentRow : records ) {
            lowestHumidity = dataHelper.getHigherHumidityOfTwoRecords(currentRow, lowestHumidity);
        }
        return lowestHumidity;
    }

    public double getAverageTemperature(List<CSVRecord> records) {
        int counter = 0;
        double temperatureSum = 0;
        for ( CSVRecord currentRow : records ) {
            double currentTempRow = Double.parseDouble(currentRow.get("TemperatureF"));
            counter += 1;
            temperatureSum = temperatureSum + currentTempRow;
        }
        return temperatureSum / counter;
    }

    public double getAverageTemperatureWhenHumidityIsHigh(List<CSVRecord> records, int minimumHumidityToCheckFor) {
        int counter = 0;
        double TemperatureSum = 0;
        double averageTemperatureWhenHumidityHigh = 0;
        for ( CSVRecord currentRow : records ) {

            if ( currentRow.get("Humidity").matches("\\d+") ) { //weather station get a broken value sometimes
                int currentHumidityInteger = Integer.parseInt(currentRow.get("Humidity"));
                if ( currentHumidityInteger >= minimumHumidityToCheckFor ) {
                    double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
                    TemperatureSum = currentTemperature + TemperatureSum;
                    counter++;
                }
            }

        }
        if ( counter != 0 && TemperatureSum != 0) {
            averageTemperatureWhenHumidityHigh = TemperatureSum / counter;
        }
        return averageTemperatureWhenHumidityHigh;
    }

}
