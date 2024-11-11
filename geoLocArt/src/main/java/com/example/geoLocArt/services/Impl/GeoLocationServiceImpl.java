package com.example.geoLocArt.services.Impl;

import com.example.geoLocArt.dto.GeoLWeatherResponseDto;
import com.example.geoLocArt.entity.GeoResponse;
import com.example.geoLocArt.entity.WeatherResponse;
import com.example.geoLocArt.services.IGeoLocationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class GeoLocationServiceImpl implements IGeoLocationService {

    @Value("${google.api.key}")
    private String Geokey;

    @Value("${openweather.api.key}")
    private String Weatherkey;

    @Override
    public GeoResponse getLocation(String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("address", address)
                .queryParam("key", Geokey).build();
        System.out.println(uri.toUriString());
        //System.out.println(new RestTemplate().getForEntity(uri.toUriString(), String.class).getBody());
        ResponseEntity<GeoResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeoResponse.class);

        return response.getBody();
    }

    @Override
    public WeatherResponse getWeather(double lat, double lng) {
        System.out.println(lat+" "+lng);
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/weather")
                .queryParam("lat", lat)
                .queryParam("lon", lng)
                .queryParam("APPID", Weatherkey)
                .build();
        System.out.println(uri.toUriString());
        ResponseEntity<WeatherResponse> response = new RestTemplate().getForEntity(uri.toUriString(), WeatherResponse.class);

        return response.getBody();
    }

    @Override
    public WeatherResponse getWeatherLoc(String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/geocode/json")
                .queryParam("address", address)
                .queryParam("key", Geokey).build();
        System.out.println(uri.toUriString());
        //System.out.println(new RestTemplate().getForEntity(uri.toUriString(), String.class).getBody());
        ResponseEntity<GeoResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeoResponse.class);
        double Lat =response.getBody().getResults()[0].getGeometry().getLocation().getLat();
        double  Lng =response.getBody().getResults()[0].getGeometry().getLocation().getLng();
        WeatherResponse responseDto = getWeather(Lat,Lng);
        return responseDto;
    }
}
