package com.apps.weather.controller;

import com.apps.weather.Period;
import com.apps.weather.Weather;
import com.apps.weather.controller.response.ResponseError;
import com.apps.weather.controller.response.ResponseOk;
import com.apps.weather.controller.response.ResponsePrediction;
import com.apps.weather.controller.response.ResponseWeather;
import com.apps.weather.service.WeatherService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WeatherController {

    public WeatherController(final WeatherService weatherService) {
        port(8080);
        initializeRoutes(weatherService);
    }

    private void initializeRoutes(WeatherService weatherService) {
        get("/clima", (request, response) -> {
            response.type("application/json");
            final String day = request.queryParams("dia");
            if (day == null) {
                response.status(400);
                return new ResponseError("Parametro dia no encontrado");
            }
            if (!StringUtils.isNumeric(day)) {
                response.status(400);
                return new ResponseError("Parametro dia debe ser numerico");
            }
            final Weather weather = weatherService.get(day);
            if (weather == null) {
                response.status(500);
                return new ResponseError("Prediccion para dia solicitado no pudo ser encontrada");
            }
            response.status(200);
            return new ResponseWeather(Integer.valueOf(day), weather.getName());
        }, new WeatherResponseTransformer());

        post("/predecir", (request, response) -> {
            final String days = request.queryParams("dias");
            if (days == null) {
                response.status(400);
                return new ResponseError("Parametro dias no encontrado");
            }
            if (!StringUtils.isNumeric(days)) {
                response.status(400);
                return new ResponseError("Parametro dias debe ser numerico");
            }
            response.status(200);
            return new ResponsePrediction(weatherService.predict(days));
        }, new WeatherResponseTransformer());

        get("/predicciones", (request, response) -> {
            final Map<Weather, List<Period>> allPredictions = weatherService.getAllPredictions();
            response.status(200);
            if (allPredictions.isEmpty()) {
                return new ResponseError("Aun no se han realizado predcciones");
            } else {
                return new ResponsePrediction(allPredictions);
            }
        }, new WeatherResponseTransformer());

        delete("/reset", (request, response) -> {
            try {
                weatherService.clear();
                response.status(200);
                return new ResponseOk();
            } catch (Exception e) {
                return new ResponseError(e.getMessage());
            }
        }, new WeatherResponseTransformer());
    }

}
