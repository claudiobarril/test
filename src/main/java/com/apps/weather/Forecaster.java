package com.apps.weather;

import com.apps.model.stars.SolarSystem;
import com.apps.weather.predictor.Predictor;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Forecaster {

    private List<Predictor> predictors;
    private SolarSystem solarSystem;
    private Weather currentWeather;
    private Map<Weather, List<Period>> periods = Maps.newEnumMap(Weather.class);
    private Period currentPeriod;

    public Forecaster(SolarSystem solarSystem, List<Predictor> predictors) {
        this.solarSystem = solarSystem;
        this.predictors = predictors;
        this.initPrediction();
    }

    private void initPrediction() {
        this.currentWeather = getWeather();
        this.resetCurrentPeriod(this.currentWeather, 0);
    }

    private void resetCurrentPeriod(Weather weather, long firstDay) {
        if (Weather.RAIN.equals(weather)) {
            this.currentPeriod = new RainPeriod(firstDay, solarSystem.getPerimeter());
        } else {
            this.currentPeriod = new Period(firstDay);
        }
    }

    private Weather getWeather() {
        return this.predictors.stream().map(predictor -> predictor.predict(solarSystem))
                .filter(Objects::nonNull).findFirst().orElse(null);
    }

    public Weather predict(Long dayNumber) {
        final Weather newWeather = getWeather();
        this.updatePeriod(newWeather, dayNumber);
        this.currentWeather = newWeather;
        return this.currentWeather;
    }

    private void updatePeriod(Weather newWeather, Long dayNumber) {
        if (newWeather != this.currentWeather) {;
            this.currentPeriod.setLastDay(dayNumber);
            List<Period> periods = getCurrentWeatherPeriods();
            periods.add(this.currentPeriod);
            this.periods.put(this.currentWeather, periods);
            resetCurrentPeriod(newWeather, dayNumber);
        } else {
            this.currentPeriod.update(solarSystem, dayNumber);
        }
    }

    private List<Period> getCurrentWeatherPeriods() {
        List<Period> periods = this.periods.get(this.currentWeather);
        if (periods == null) {
            periods = Lists.newArrayList();
        }
        return periods;
    }

    public Map<Weather, List<Period>> getPeriods() {
        return periods;
    }

    public void clearPeriods() {
        this.periods.clear();
    }
}
