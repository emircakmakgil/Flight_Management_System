package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.core.exception.type.BusinessException;
import com.turkcell.flightmanagementsystem.dto.campaign.CampaignListiningDto;
import com.turkcell.flightmanagementsystem.dto.campaign.CreateCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.DeleteCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.UpdateCampaignDto;
import com.turkcell.flightmanagementsystem.entity.Campaign;
import com.turkcell.flightmanagementsystem.entity.Flight;
import com.turkcell.flightmanagementsystem.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;


    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;

    }

    @Override
    public Optional<Campaign> findById(UUID id) {
        return campaignRepository.findById(id);
    }

    @Override
    public void add(CreateCampaignDto createCampaignDto) {
       // Flight flight =flightService.findById(createCampaignDto.getFlightId()).orElseThrow(()->new BusinessException("Flight Not Found"));
        Campaign campaign = new Campaign();
        campaign.setName(createCampaignDto.getName());
       // campaign.setFlight(flight);
        campaign.setDescription(createCampaignDto.getDescription());
        campaign.setStartDate(createCampaignDto.getStartDate());
        campaign.setEndDate(createCampaignDto.getEndDate());
        campaign.setDiscountPercentage(createCampaignDto.getDiscountPercentage());
        campaignRepository.save(campaign);
    }

    @Override
    public Campaign update(UpdateCampaignDto updateCampaignDto) {
        //Flight flight=flightService.findById(updateCampaignDto.getFlight().getId()).orElseThrow(()->new BusinessException("Flight Not Found"));
        Campaign campaign=campaignRepository.findById(updateCampaignDto.getId()).orElseThrow(()->new BusinessException("Campaign Not Found"));
        campaign.setName(updateCampaignDto.getName());
        campaign.setDescription(updateCampaignDto.getDescription());
        campaign.setStartDate(updateCampaignDto.getStartDate());
        campaign.setEndDate(updateCampaignDto.getEndDate());
       // campaign.setFlight(flight);
        campaign.setDiscountPercentage(updateCampaignDto.getDiscountPercentage());

        return campaignRepository.save(campaign);

    }

    @Override
    public void delete(DeleteCampaignDto deleteCampaignDto) {
        Campaign campaign=campaignRepository.findById(deleteCampaignDto.getId()).orElseThrow(()->new BusinessException("Campaign Not Found"));
        campaignRepository.delete(campaign);

    }

    @Override
    public List<CampaignListiningDto> getAll() {
        List<CampaignListiningDto> campaignListiningDtos=campaignRepository
                .findAll()
                .stream()
                .map((campaign) -> new CampaignListiningDto(campaign.getName(),campaign.getDescription(),campaign.getStartDate(),campaign.getEndDate(),campaign.getDiscountPercentage()))
                .toList();
        return campaignListiningDtos;
    }
}
