# Weather Data CSV Parsing and Analysis
This is a Java project designed to parse and analyze weather data from CSV files. The program comprises multiple components, including a parser, analyzer, and reporter.

## Components
### WeatherDataParser
The WeatherDataParser is in charge of parsing the data from the CSV files.

### WeatherAnalyzer
The WeatherAnalyzer class offers various analysis methods for the parsed data:

##### **getRecordWithHighestTemperature**: This method scans through the records and returns the one with the highest temperature.
##### **getRecordWithColdestTemperature**: This method scans through the records and returns the one with the coldest temperature.
##### **getRecordWithLowestHumidity**: This method scans through the records and returns the one with the lowest humidity.
##### **getRecordWithHighestHumidity**: This method scans through the records and returns the one with the highest humidity.
##### **getAverageTemperature**: This method calculates and returns the average temperature of all records.
##### **getAverageTemperatureWhenHumidityIsHigh**: This method calculates and returns the average temperature for all records where humidity is above a certain threshold.

### Main class
The Main class employs the WeatherDataParser and WeatherAnalyzer to parse the weather data, analyze it, and report the results. It calculates various metrics such as the hottest and coldest temperatures, highest and lowest humidity levels, the average temperature, and the average temperature when humidity is above a specified threshold (80 in the provided code).
