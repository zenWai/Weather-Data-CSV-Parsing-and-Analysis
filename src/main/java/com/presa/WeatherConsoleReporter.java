package main.java.com.presa;

import lib.csv.CSVRecord;

public class WeatherConsoleReporter {
    private final WeatherDataAnalyticHelpers dataHelpers;
    public WeatherConsoleReporter() {
        this.dataHelpers =new WeatherDataAnalyticHelpers();
    }

    public void reportHottestTemperature(CSVRecord record) {
        double temperatureF = Double.parseDouble(record.get("TemperatureF"));
        double temperatureC = dataHelpers.getCelsiusFromFahrenheit(temperatureF);
        temperatureF = dataHelpers.truncateToOneDecimal(temperatureF);
        temperatureC = dataHelpers.truncateToOneDecimal(temperatureC);
        String dateUTC = record.get("DateUTC");

        System.out.println("Hottest temperature was " +
                temperatureF +
                "°F/" +
                temperatureC +
                "°C at " +
                dateUTC +
                " UTC time");
    }

    public void reportColdestTemperature(CSVRecord record) {
        double temperatureF = Double.parseDouble(record.get("TemperatureF"));
        double temperatureC = dataHelpers.getCelsiusFromFahrenheit(temperatureF);
        temperatureC = dataHelpers.truncateToOneDecimal(temperatureC);
        String dateUTC = record.get("DateUTC");

        System.out.println("Coldest temperature was " +
                temperatureF +
                "°F/" +
                temperatureC +
                "°C at " +
                dateUTC +
                " UTC time");
    }

    public void reportLowestHumidity(CSVRecord record) {
        System.out.println("Lowest Humidity was " +
                record.get("Humidity") +
                " at " +
                record.get("DateUTC") +
                " UTC");
    }

    public void reportHigherHumidity(CSVRecord record) {
        System.out.println("Highest Humidity was " +
                record.get("Humidity") +
                " at " +
                record.get("DateUTC") +
                " UTC");
    }

    public void reportAverageTemperatureInFile(Double averageTempF) {
        double averageTempC = dataHelpers.getCelsiusFromFahrenheit(averageTempF);
        averageTempF = dataHelpers.truncateToOneDecimal(averageTempF);
        averageTempC = dataHelpers.truncateToOneDecimal(averageTempC);
        System.out.println("The average temperature was " +
                averageTempF +
                "°F/" +
                averageTempC +
                "°C");
    }

    public void reportAverageTemperatureWithHighHumidity(
            double averageTemperatureWithHighHumidity,
            int minimumHumidityCheckedFor ) {

        if ( averageTemperatureWithHighHumidity == 0 ) {
            System.out.println("No temperatures found when humidity was higher than " + minimumHumidityCheckedFor);
        }else {
            System.out.println("The average temperature when humidity is higher than " +
                    minimumHumidityCheckedFor +
                    " was " +
                    dataHelpers.truncateToOneDecimal(averageTemperatureWithHighHumidity) +
                    "°F/" +
                    dataHelpers.truncateToOneDecimal(
                            dataHelpers.getCelsiusFromFahrenheit(averageTemperatureWithHighHumidity)) +
                    "°C");
        }
    }
}
