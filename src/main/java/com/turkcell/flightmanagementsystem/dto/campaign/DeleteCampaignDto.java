package com.turkcell.flightmanagementsystem.dto.campaign;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class DeleteCampaignDto {
    @NotNull
    private UUID id;
}
