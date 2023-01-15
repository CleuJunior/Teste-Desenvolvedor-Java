package com.automobilefleet.api.request;

import com.automobilefleet.entities.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarImageRequest {

    @JsonProperty("car_id")
    private Car car;

    @JsonProperty("image")
    private byte[] image;

}