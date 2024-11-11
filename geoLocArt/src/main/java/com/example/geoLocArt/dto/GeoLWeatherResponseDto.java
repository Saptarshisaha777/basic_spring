package com.example.geoLocArt.dto;

import com.example.geoLocArt.entity.GeoResponse;
import com.example.geoLocArt.entity.WeatherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLWeatherResponseDto {
    private ResponseDto responseDto;
    private WeatherResponse weatherResponse;
}
