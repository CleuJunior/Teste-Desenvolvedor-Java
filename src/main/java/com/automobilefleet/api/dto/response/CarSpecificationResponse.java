package com.automobilefleet.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@JsonPropertyOrder({"_id"})
public class CarSpecificationResponse {
    @JsonProperty("_id")
    private UUID id;

    @JsonProperty("car")
    private CarResponse car;

    @JsonProperty("specification")
    private SpecificationResponse specification;
}