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

    private static void printSystemLocations(SolarSystem solarSystem) {
        List<Planet> planets = solarSystem.getPlanets();
        printPlanetLocation(planets.get(0));
        printPlanetLocation(planets.get(1));
        printPlanetLocation(planets.get(2));
    }

    private static void printPlanetLocation(Planet planet) {
        System.out.println("Angle: " + planet.getAngle() + " X: " + planet.getX() + " Y: " + planet.getY());
    }
}
