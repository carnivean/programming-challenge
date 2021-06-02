package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        MaxAbsDiffOfStream maxAbsDiffOfStream = new MaxAbsDiffOfStream();

        CSVToStream csvToStream = new CSVToStream();
        String dayWithSmallestTempSpread =    maxAbsDiffOfStream.doDataScience(csvToStream.loadDatasource(
                "weather.csv", CSVToStream.mapWeatherData));  // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = maxAbsDiffOfStream.doDataScience(csvToStream.loadDatasource(
                "football.csv", CSVToStream.mapFootballData));  // Your day analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        System.out.printf("%nSome additional stuff ;) %n");
        InterestingDataScience ds = new InterestingDataScience();
        String a =    ds.doDataScience(csvToStream.loadDatasource("weather.csv", CSVToStream.mapWeatherData));  // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", a);

        String b = ds.doDataScience(csvToStream.loadDatasource("football.csv", CSVToStream.mapFootballData));  // Your day analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", b);

    }
}
