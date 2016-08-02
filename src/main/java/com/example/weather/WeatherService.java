package com.example.weather;

import com.example.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private WeatherType currentWeather = WeatherType.SUNNY;

    @Autowired
    EventService eventService;

    public void timePasses(){
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.println("The weather changed to " + currentWeather + ".");
        notifingWeatherChange();
    }

    private void notifingWeatherChange(){
        eventService.notifyEvent(new WeatherChangeEvent(currentWeather.name()));
    }

    public enum WeatherType{
        SUNNY, CLOUDY, RAINY
    }
}
