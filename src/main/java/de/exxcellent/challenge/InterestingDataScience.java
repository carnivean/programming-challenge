package de.exxcellent.challenge;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterestingDataScience implements DataScienceOnStream {
    @Override
    public String doDataScience(Stream<QnDData> stream) {
        return stream.filter((obj) -> obj.absoluteDiff > 10)
                .sorted(Comparator.comparingInt(o -> -o.absoluteDiff))
                .limit(5)
                .map(d -> d.toString())
                .collect(Collectors.joining("; "));
    }
}
