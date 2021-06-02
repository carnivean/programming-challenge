package de.exxcellent.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class CSVToStream implements DataSourceToStream {
    @Override
    public Stream<QnDData> loadDatasource(String datasource, Function<Object, QnDData> mapperFunction) {
        var filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\de\\exxcellent\\challenge\\" + datasource;
        String result = "";
        try {
            return Files.lines(Paths.get(filePath)).skip(1).map(mapperFunction);
        } catch (IOException e) {
            /*
            Hier könnte man eine vernünftige Fehlerbehandlung machen, aber wenn die Datei fehlt, ist die Aufgabe in beiden
            Fällen nicht lösbar. Da gibt es keine wirkliche sinnvolle Fehlerbehandlung.
             */
            System.err.println("Die Datei scheint zu fehlen.");
            e.printStackTrace();
            return Stream.empty();
        }
    }

    /*
    Copied from QuickAndDirty, as we will delete the old class as soon as this one works as it should
     */
    public static Function<Object, QnDData> mapWeatherData = (obj) -> {
        // This is a really ugly cast but it is in the class itself, therefore it can be somehow excused, but still... :(
        String line = (String) obj;
        String[] td = line.split(",");
        return new QnDData(Integer.parseInt(td[1]), Integer.parseInt(td[2]), td[0]);
    };

    public static Function<Object, QnDData> mapFootballData = (obj) -> {
        String line = (String) obj;
        String[] td = line.split(",");
        return new QnDData(Integer.parseInt(td[5]), Integer.parseInt(td[6]), td[0]);
    };
}
