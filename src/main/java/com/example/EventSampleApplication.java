package com.example;

import com.example.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventSampleApplication.class, args);
    }

    @Autowired
    WeatherService weatherService;

    @Override
    public void run(String... strings) throws Exception {
        weatherService.timePasses();
        weatherService.timePasses();
        weatherService.timePasses();
        weatherService.timePasses();
        weatherService.timePasses();
        weatherService.timePasses();
    }
}
