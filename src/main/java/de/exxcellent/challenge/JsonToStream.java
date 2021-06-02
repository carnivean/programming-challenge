package de.exxcellent.challenge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class JsonToStream implements DataSourceToStream{
    private static class FootballTuple {
        public String Team;
        public int Games, Wins, Losses, Draws, Goals, Points;

        @JsonProperty("Goals Allowed")
        private int GoalsAllowed;

        public FootballTuple() { }

        public FootballTuple(String team, int games, int wins, int losses, int draws, int goals, int points, int goalsAllowed) {
            Team = team;
            Games = games;
            Wins = wins;
            Losses = losses;
            Draws = draws;
            Goals = goals;
            Points = points;
            GoalsAllowed = goalsAllowed;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown=true)
    private static class WeatherTuple {
        public int Day;
        public int MxT, MnT;

        public WeatherTuple() { }

        public WeatherTuple(int day, int mxT, int mnT) {
            Day = day;
            MxT = mxT;
            MnT = mnT;
        }
    }

    @Override
    public Stream<QnDData> loadDatasource(String datasource, Function<Object, QnDData> mapperFunction) {
        ObjectMapper mapper = new ObjectMapper();
        var filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\de\\exxcellent\\challenge\\" + datasource;
        File jsonFile = new File(filePath).getAbsoluteFile();
        List<FootballTuple> data = null;
        try {
            if (datasource.equals("weather.json")) {
                return Arrays.asList(mapper.readValue(jsonFile, WeatherTuple[].class))
                    .stream().map(JsonToStream.mapWeatherData);
            } else if (datasource.equals("football.json")) {
                return Arrays.asList(mapper.readValue(jsonFile, FootballTuple[].class))
                        .stream().map(JsonToStream.mapFootballData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    public static Function<FootballTuple, QnDData> mapFootballData = (obj) -> new QnDData(obj.Goals, obj.GoalsAllowed, obj.Team);

    public static Function<WeatherTuple, QnDData> mapWeatherData = (o) -> new QnDData(o.MxT, o.MnT, "" + o.Day);
}
