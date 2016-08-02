package com.example.weather;

import com.example.event.Event;

public class WeatherChangeEvent extends Event{
    private String weather;

    public WeatherChangeEvent(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
}
