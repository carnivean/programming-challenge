package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CSVToStreamTest {

    @Test
    void loadDatasource() {
        CSVToStream csvToStream = new CSVToStream();
        Stream<QnDData> s = csvToStream.loadDatasource("weather.csv", CSVToStream.mapWeatherData);
        long c = s.count();
        assertEquals(30, c, "Stream doesnt has the right number of elements for weather dataset");

        s = csvToStream.loadDatasource("weather.csv", CSVToStream.mapWeatherData);
        QnDData data = s.findFirst().orElseThrow();
        assertEquals("1", data.result, "Attributes of first elements wrongly mapped.");
        assertEquals(88, data.max, "Attributes of first elements wrongly mapped.");
        assertEquals(59, data.min, "Attributes of first elements wrongly mapped.");
        assertEquals(29, data.absoluteDiff, "Attributes of first elements wrongly mapped.");

        s = csvToStream.loadDatasource("football.csv", CSVToStream.mapFootballData);
        c = s.count();
        assertEquals(20, c, "Stream doesnt has the right number of elements for football dataset");

        s = csvToStream.loadDatasource("football.csv", CSVToStream.mapFootballData);
        data = s.findFirst().orElseThrow();
        assertEquals("Arsenal", data.result, "Attributes of first elements wrongly mapped.");
        assertEquals(79, data.max, "Attributes of first elements wrongly mapped.");
        assertEquals(36, data.min, "Attributes of first elements wrongly mapped.");
        assertEquals(43, data.absoluteDiff, "Attributes of first elements wrongly mapped.");
    }
}