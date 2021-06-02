package de.exxcellent.challenge;

import java.util.function.Function;
import java.util.stream.Stream;

public interface DataSourceToStream {
    /*
    String datasource Can we either the filename or the url for a rest api call etc
    Returns a stream of QnDData, so the implementing classes have to map the data, which logically make sense for me
     */
    public Stream<QnDData> loadDatasource(String datasource, Function<Object, QnDData> mapperFunction);
}
