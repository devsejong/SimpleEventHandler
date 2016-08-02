package com.example.client;

import com.example.event.EventHandler;
import com.example.weather.WeatherAnotherEvent;
import org.springframework.stereotype.Service;

@Service
public class AnotherWeatherEventHandler implements EventHandler<WeatherAnotherEvent>{

    @Override
    public void handle(WeatherAnotherEvent event) {
        System.out.println("여기가 호출되면 안되요!!");
    }
}
