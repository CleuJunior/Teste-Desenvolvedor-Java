package com.automobilefleet.api.mapper;

import com.automobilefleet.api.reponse.CostumerResponse;
import com.automobilefleet.api.request.CostumerRequest;
import com.automobilefleet.entities.Costumer;


public class CostumerMapper {

    private CostumerMapper() { }

    public static Costumer toCostumer(CostumerRequest request) {
        Costumer costumer = new Costumer();
        costumer.setName(request.getName());
        costumer.setBirthDate(request.getBirthDate());
        costumer.setEmail(request.getEmail());
        costumer.setDriveLicense(request.getDriveLicense());
        costumer.setAddress(request.getAddress());
        costumer.setPhone(request.getPhone());

        return costumer;
    }

    public static CostumerResponse toCostumerResponse(Costumer costumer) {
        CostumerResponse response = new CostumerResponse();
        response.setId(costumer.getId());
        response.setName(costumer.getName());
        response.setBirthDate(costumer.getBirthDate());
        response.setEmail(costumer.getEmail());
        response.setDriveLicense(costumer.getDriveLicense());
        response.setAddress(costumer.getAddress());
        response.setPhone(costumer.getPhone());
        response.setCreatedAt(costumer.getCreatedAt());

        return response;
    }
}
