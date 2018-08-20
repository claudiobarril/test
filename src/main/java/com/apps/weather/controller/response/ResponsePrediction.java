package com.apps.weather.controller.response;

import com.apps.weather.Period;
import com.apps.weather.Weather;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class ResponsePrediction {

    private Map<Weather, Integer> periodsCounter = Maps.newEnumMap(Weather.class);
    private Map<Weather, List<Period>> periodsDetails;

    public ResponsePrediction(Map<Weather, List<Period>> periodsDetails) {
        this.periodsDetails = periodsDetails;
        this.periodsDetails.forEach((key, list) -> periodsCounter.put(key, list.size()));
    }
}
