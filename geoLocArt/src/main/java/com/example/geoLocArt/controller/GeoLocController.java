package com.example.geoLocArt.controller;

import com.example.geoLocArt.dto.GeoLWeatherResponseDto;
import com.example.geoLocArt.dto.GeoLocationResponseDto;
import com.example.geoLocArt.dto.ResponseDto;
import com.example.geoLocArt.entity.GeoResponse;
import com.example.geoLocArt.entity.Results;
import com.example.geoLocArt.entity.WeatherResponse;
import com.example.geoLocArt.services.IGeoLocationService;
import com.example.geoLocArt.services.Impl.GeoLocationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/api_geo", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GeoLocController {

    private final IGeoLocationService geoLocationService;



    @GetMapping("/test")
    public String TestControl() {
        return "Hello World";
    }

    @GetMapping("/getLocation")
    public ResponseEntity<GeoLocationResponseDto> getLocation(@RequestParam String address) {
        GeoResponse geoResponse = geoLocationService.getLocation(address);
        return ResponseEntity.status(200).body(new GeoLocationResponseDto( new ResponseDto("200", "Success"),geoResponse));
    }

    @GetMapping("/getWeather")
    public ResponseEntity<GeoLWeatherResponseDto> getWeather(@RequestParam String address) {
        WeatherResponse weatherResponse = geoLocationService.getWeatherLoc(address);
        return ResponseEntity.status(200).body(new GeoLWeatherResponseDto( new ResponseDto("200", "Success"),weatherResponse));
    }

}
