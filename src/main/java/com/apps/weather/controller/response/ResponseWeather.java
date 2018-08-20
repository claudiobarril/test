package com.apps.weather.controller.response;

import com.apps.weather.Weather;

public class ResponseWeather {

    private Integer day;
    private Weather weather;

    public ResponseWeather(Integer day, Weather weather) {
        this.day = day;
        this.weather = weather;
    }

    public Integer getDay() {
        return day;
    }

    public Weather getWeather() {
        return weather;
    }
}
