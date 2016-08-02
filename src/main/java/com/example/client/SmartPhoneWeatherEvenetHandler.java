package com.example.client;


import com.example.event.EventHandler;
import com.example.weather.WeatherChangeEvent;
import org.springframework.stereotype.Service;

@Service
public class SmartPhoneWeatherEvenetHandler implements EventHandler<WeatherChangeEvent>{
    @Override
    public void handle(WeatherChangeEvent event) {
        System.out.println("스마트폰으로 날씨를 알림");
    }
}
