package com.turkcell.flightmanagementsystem.dto.campaign;

import com.turkcell.flightmanagementsystem.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CampaignListiningDto {
    private String name;
    private double discountPercentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;


    public CampaignListiningDto(String name, String description, LocalDate startDate, LocalDate endDate, double discountPercentage) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage=discountPercentage;



    }
}
