package com.apps.weather.controller.response;

import com.google.gson.annotations.SerializedName;

public class ResponseOk {
    @SerializedName("mensaje")
    private String message;

    public ResponseOk() {
        this.message = "OK";
    }
}
