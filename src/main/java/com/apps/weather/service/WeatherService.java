package com.apps.weather.service;

import com.apps.weather.Period;
import com.apps.weather.database.WeatherStore;
import com.apps.model.stars.SolarSystem;
import com.apps.weather.Forecaster;
import com.apps.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

@Service
public class WeatherService {

    private final WeatherStore store;
    private final SolarSystem solarSystem;
    private final Forecaster forecaster;

    @Autowired
    public WeatherService(WeatherStore store, SolarSystem solarSystem, Forecaster forecaster) {
        this.store = store;
        this.solarSystem = solarSystem;
        this.forecaster = forecaster;
    }

    public Weather get(String day) {
        return store.get(day);
    }

    public Map<Weather, List<Period>> predict(String days) {
        LongStream.rangeClosed(1, Long.valueOf(days)).forEach(i -> {
            solarSystem.advance();
            Weather weather = forecaster.predict(i);
            store.put(String.valueOf(i), weather);
        });
        return forecaster.getPeriods();
    }

    public void clear() throws IOException {
        store.clear();
    }
}
