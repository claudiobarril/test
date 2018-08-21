package com.apps.weather.controller.response;

import com.google.gson.annotations.SerializedName;

public class ResponseError {
    @SerializedName("mensaje")
    private String message;

    public ResponseError(String message) {
        this.message = message;
    }
}
