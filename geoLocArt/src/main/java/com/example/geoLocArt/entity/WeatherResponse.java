package com.example.geoLocArt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private Weather[] weather;
    private MainData main;
    private String id;
    private String name;
    private String cod;
}
