package com.example.geoLocArt.dto;

import com.example.geoLocArt.entity.GeoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocationResponseDto {
    private ResponseDto responseDto;
    private GeoResponse georesponse;
}
