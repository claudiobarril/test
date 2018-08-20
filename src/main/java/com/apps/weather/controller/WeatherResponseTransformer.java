package com.apps.weather.controller;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class WeatherResponseTransformer implements ResponseTransformer {
    @Override
    public String render(Object response) {
        return new Gson().toJson(response);
    }
}
