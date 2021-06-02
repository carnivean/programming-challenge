package de.exxcellent.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxAbsDiffOfStreamTest {

    @Test
    void doDataScience() {
        List<QnDData> l = new LinkedList<>();
        l.add(new QnDData(100, 20, "false"));
        l.add(new QnDData(70, 20, "false"));
        l.add(new QnDData(10, -20, "right"));
        l.add(new QnDData(-100, -200, "false"));

        MaxAbsDiffOfStream ds = new MaxAbsDiffOfStream();
        String r = ds.doDataScience(l.stream());
        assertEquals("right", r);
    }

    @Test
    void doDataScienceOneElement() {
        List<QnDData> l = new LinkedList<>();
        l.add(new QnDData(100, 20, "false"));

        MaxAbsDiffOfStream ds = new MaxAbsDiffOfStream();
        String r = ds.doDataScience(l.stream());
        assertEquals("false", r);
    }
}