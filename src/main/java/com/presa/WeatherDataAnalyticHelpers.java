package main.java.com.presa;

import lib.csv.CSVRecord;

public class WeatherDataAnalyticHelpers {

    public CSVRecord getLargestTemperatureOfTwoRecords(CSVRecord currentRow, CSVRecord largestSoFar) {
        if ( largestSoFar == null ) {
            largestSoFar = currentRow;
        }else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if ( currentTemp > largestTemp ) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public CSVRecord getLowerTemperatureOfTwoRecords(CSVRecord currentRow, CSVRecord lowerValueSoFar) {
        if ( lowerValueSoFar == null ) {
            lowerValueSoFar = currentRow;
        }else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(lowerValueSoFar.get("TemperatureF"));
            if ( (currentTemp < coldestTemp) && (currentTemp != -9999) ) {
                lowerValueSoFar = currentRow;
            }
        }
        return lowerValueSoFar;
    }

    public CSVRecord getLowerHumidityOfTwoRecords(CSVRecord currentRow, CSVRecord lowestHumiditySoFar) {
        if ( lowestHumiditySoFar == null ) {
            lowestHumiditySoFar = currentRow;
        } else if ( humidityValueNotBroken(currentRow) ) {
            int currentHumidityInteger = Integer.parseInt(currentRow.get("Humidity"));
            int lowestHumidityInteger = Integer.parseInt(lowestHumiditySoFar.get("Humidity"));
            if ( (currentHumidityInteger < lowestHumidityInteger) ) {
                lowestHumiditySoFar = currentRow;
            }
        }
        return lowestHumiditySoFar;
    }

    public CSVRecord getHigherHumidityOfTwoRecords(CSVRecord currentRow, CSVRecord highestHumiditySoFar) {
        if ( highestHumiditySoFar == null ) {
            highestHumiditySoFar = currentRow;
        } else if ( humidityValueNotBroken(currentRow) ) {
            int currentHumidityInteger = Integer.parseInt(currentRow.get("Humidity"));
            int highestHumidityInteger = Integer.parseInt(highestHumiditySoFar.get("Humidity"));
            if ( (currentHumidityInteger > highestHumidityInteger) ) {
                highestHumiditySoFar = currentRow;
            }
        }
        return highestHumiditySoFar;
    }

    public boolean humidityValueNotBroken(CSVRecord currentRow) {
        return currentRow.get("Humidity").matches("\\d+");
    }

    public double truncateToThreeDecimals(double num){
        return Math.floor(num * 1000) / 1000;
    }

    public double truncateToOneDecimal(double num) {
        return Math.floor(num * 10) / 10;
    }

    public double getCelsiusFromFahrenheit(double temperatureF){
        return (temperatureF - 32)/1.8;
    }
}
