package com.example.geoLocArt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Results {
    @JsonProperty("formatted_address")
    private String formatted_address;
    private Geometry geometry;
}
