package com.example.geoLocArt.services;

import com.example.geoLocArt.dto.GeoLWeatherResponseDto;
import com.example.geoLocArt.entity.GeoResponse;
import com.example.geoLocArt.entity.WeatherResponse;
import org.springframework.context.annotation.Configuration;


public interface IGeoLocationService {

    GeoResponse getLocation(String address);

    WeatherResponse getWeather(double lat, double lng);

    WeatherResponse getWeatherLoc(String address);
}
