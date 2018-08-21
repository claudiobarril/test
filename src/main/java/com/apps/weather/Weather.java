package com.apps.weather;

import java.io.Serializable;

public enum Weather implements Serializable {
    DROUGHT("sequía"),
    RAIN("lluvia"),
    OPTIMAL("óptimo"),
    OTHER("otro");

    private final String name;

    Weather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
