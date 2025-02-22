package com.turkcell.flightmanagementsystem.controller;

import com.turkcell.flightmanagementsystem.dto.campaign.CampaignListiningDto;
import com.turkcell.flightmanagementsystem.dto.campaign.CreateCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.DeleteCampaignDto;
import com.turkcell.flightmanagementsystem.dto.campaign.UpdateCampaignDto;
import com.turkcell.flightmanagementsystem.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateCampaignDto createCampaignDto) {
        this.campaignService.add(createCampaignDto);
    }
    @GetMapping
    public List<CampaignListiningDto> getAll(){
        return this.campaignService.getAll();
    }
    @PutMapping
    public void update(@RequestBody UpdateCampaignDto updateCampaignDto) {
        this.campaignService.update(updateCampaignDto);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteCampaignDto deleteCampaignDto) {
        this.campaignService.delete(deleteCampaignDto);
    }
}
