package com.example.geoLocArt.dto;

import com.example.geoLocArt.entity.GeoResponse;
import com.example.geoLocArt.entity.Results;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;
    private String stsMsg;
}
