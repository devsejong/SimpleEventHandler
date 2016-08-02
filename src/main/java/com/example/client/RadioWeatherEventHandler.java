package com.example.client;

import com.example.event.EventHandler;
import com.example.weather.WeatherChangeEvent;
import org.springframework.stereotype.Service;

@Service
public class RadioWeatherEventHandler implements EventHandler<WeatherChangeEvent>{

    @Override
    public void handle(WeatherChangeEvent event) {
        System.out.println("라디오로 작업을 알림");
    }
}
