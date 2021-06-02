package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

public class QuickAndDirty {
    public static String processCSVFile(String fileName, Function<String, QnDData> mapperFunction) {
        var filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "de" +  File.separator + "exxcellent" +
                File.separator + "challenge" + File.separator + fileName;
        String result = "";
        try {
            result = Files.lines(Paths.get(filePath))
                    .skip(1)
                    .map(mapperFunction)
                    .min((o1, o2) -> o1.absoluteDiff - o2.absoluteDiff)
                    .get()
                    .result;
        } catch (IOException e) {
            /*
            Hier könnte man eine vernünftige Fehlerbehandlung machen, aber wenn die Datei fehlt, ist die Aufgabe in beiden
            Fällen nicht lösbar. Da gibt es keine wirkliche sinnvolle Fehlerbehandlung.
             */
            System.err.println("Die Datei scheint zu fehlen.");
            e.printStackTrace();
        }
        return result;
    }


    /*
    Lamdas :)
     */
    public static Function<String, QnDData> mapWeatherData = (line) -> {
        String[] td = line.split(",");
        return new QnDData(Integer.parseInt(td[1]), Integer.parseInt(td[2]), td[0]);
    };

    public static Function<String, QnDData> mapFootballData = (line) -> {
        String[] td = line.split(",");
        return new QnDData(Integer.parseInt(td[5]), Integer.parseInt(td[6]), td[0]);
    };
}
