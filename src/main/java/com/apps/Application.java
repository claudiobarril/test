package com.apps;

import com.apps.configuration.ModelConfiguration;
import com.apps.weather.controller.WeatherController;
import com.apps.model.stars.Planet;
import com.apps.model.stars.SolarSystem;
import com.apps.weather.service.WeatherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan({"com.apps.weather.service"})
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class, ModelConfiguration.class);
        new WeatherController(ctx.getBean(WeatherService.class));
        ctx.registerShutdownHook();
    }

}
