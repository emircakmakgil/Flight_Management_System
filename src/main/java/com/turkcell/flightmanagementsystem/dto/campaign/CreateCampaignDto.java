package com.turkcell.flightmanagementsystem.dto.campaign;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CreateCampaignDto {
    @NotBlank(message = "Kampanya adını giriniz.")
    private String name;
    @NotBlank
    @Size(min = 1, max = 100)
    private double discountPercentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
