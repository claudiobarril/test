package com.apps.configuration;

import com.apps.weather.database.WeatherStore;
import com.apps.model.location.ClockWise;
import com.apps.model.location.CounterClockWise;
import com.apps.model.stars.Planet;
import com.apps.model.stars.SolarSystem;
import com.apps.model.stars.Star;
import com.apps.weather.Forecaster;
import com.apps.weather.predictor.DefaultPredictor;
import com.apps.weather.predictor.DroughtPredictor;
import com.apps.weather.predictor.OptimalPredictor;
import com.apps.weather.predictor.Predictor;
import com.apps.weather.predictor.RainPredictor;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
public class ModelConfiguration {

    @Bean
    public SolarSystem solarSystem() {
        Star star = new Star();
        SolarSystem solarSystem = new SolarSystem(star);
        solarSystem.add(new Planet(star, new ClockWise(500, 1)));
        solarSystem.add(new Planet(star, new CounterClockWise(1000, 5)));
        solarSystem.add(new Planet(star, new ClockWise(2000, 3)));
        return solarSystem;
    }

    @Bean
    public Forecaster forecaster() {
        List<Predictor> predictors = Lists.newArrayList(
                new DroughtPredictor(),
                new OptimalPredictor(),
                new RainPredictor(),
                new DefaultPredictor()
        );
        return new Forecaster(solarSystem(), predictors);
    }

    @Bean
    public WeatherStore store() throws IOException {
        return new WeatherStore("weather");
    }
}
