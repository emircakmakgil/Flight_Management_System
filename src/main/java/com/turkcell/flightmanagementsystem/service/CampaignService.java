package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.campaign.CampaignListiningDto;
import com.turkcell.flightmanagementsystem.dto.campaign.CreateCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.DeleteCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.UpdateCampaignDto;
import com.turkcell.flightmanagementsystem.entity.Campaign;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampaignService {
    Optional<Campaign> findById(UUID id);
    void add(CreateCampaignDto createCampaignDto);
    Campaign update(UpdateCampaignDto updateCampaignDto);
    void delete(DeleteCampaignDto deleteCampaignDto);
    List<CampaignListiningDto> getAll();
}
