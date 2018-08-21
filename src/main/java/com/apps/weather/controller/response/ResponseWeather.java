package com.apps.weather.controller.response;

import com.google.gson.annotations.SerializedName;

public class ResponseWeather {

    @SerializedName("dia")
    private Integer day;
    @SerializedName("clima")
    private String weather;

    public ResponseWeather(Integer day, String weather) {
        this.day = day;
        this.weather = weather;
    }

    public Integer getDay() {
        return day;
    }

    public String getWeather() {
        return weather;
    }
}
