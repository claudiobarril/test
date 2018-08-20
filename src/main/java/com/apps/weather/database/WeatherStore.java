package com.apps.weather.database;

import com.apps.weather.Weather;
import org.apache.commons.lang3.SerializationUtils;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.factory;

public class WeatherStore {
    private final Options options;
    private final File file;
    private DB levelDBStore;

    public WeatherStore(String fileName) throws IOException {
        this.file = new File(fileName);
        this.options = new Options();
        this.options.createIfMissing(true);
        this.levelDBStore = factory.open(file, options);
    }

    public Weather get(String day) {
        final byte[] weatherBytes = this.levelDBStore.get(day.getBytes());
        return weatherBytes != null ? SerializationUtils.deserialize(weatherBytes) : null;
    }

    public void put(String day, Weather weather) {
        this.levelDBStore.put(day.getBytes(), SerializationUtils.serialize(weather));
    }

    public void clear() throws IOException {
        if (this.levelDBStore != null) {
            this.levelDBStore.close();
            factory.destroy(file, options);
            this.levelDBStore = factory.open(file, options);
        } else {
            throw new IllegalStateException("The database you are trying to use is not currently open");
        }
    }
}
