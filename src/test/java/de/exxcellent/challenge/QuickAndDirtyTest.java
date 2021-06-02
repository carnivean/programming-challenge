package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickAndDirtyTest {
    @Test
    void processWeatherFileTest() {
        String res = QuickAndDirty.processCSVFile("weather.csv", QuickAndDirty.mapWeatherData);
        assertEquals("14", res);
    }

    @Test
    void processFootballFileTest() {
        String res = QuickAndDirty.processCSVFile("football.csv", QuickAndDirty.mapFootballData);
        assertEquals("Aston_Villa", res);
    }
}