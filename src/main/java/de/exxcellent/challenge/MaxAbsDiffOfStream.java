package de.exxcellent.challenge;

import java.util.stream.Stream;

public class MaxAbsDiffOfStream implements DataScienceOnStream {

    @Override
    public String doDataScience(Stream<QnDData> s) {
        return s
                .min((o1, o2) -> o1.absoluteDiff - o2.absoluteDiff)
                .get()
                .result;
    }
}
