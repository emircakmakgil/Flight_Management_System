package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.campaign.CreateCampaignDto;
import com.turkcell.flightmanagementsystem.entity.Campaign;
import com.turkcell.flightmanagementsystem.repository.CampaignRepository;
import com.turkcell.flightmanagementsystem.service.impl.CampaignServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceImplTest {
    @Mock
    private CampaignRepository campaignRepository;

    @InjectMocks
    private CampaignServiceImpl campaignService;

    private UUID campaignId;
    private CreateCampaignDto createCampaignDto;
    private Campaign campaign;

    @BeforeEach
    void setup() {
        campaignId = UUID.randomUUID();

        campaign = new Campaign();
        campaign.setId(campaignId);
        campaign.setName("Test Campaign");
        campaign.setDescription("Test Description");
        campaign.setStartDate(LocalDate.now());
        campaign.setEndDate(LocalDate.now());
        campaign.setDiscountPercentage(0.2);

        createCampaignDto = new CreateCampaignDto();
        createCampaignDto.setName("Test Campaign");
        createCampaignDto.setDescription("Test Description");
        createCampaignDto.setStartDate(LocalDate.now());
        createCampaignDto.setEndDate(LocalDate.now());
        createCampaignDto.setDiscountPercentage(0.2);
    }

    @Test
    public void whenAddCalledWithValidRequest_itShouldSaveCampaignToRepository() {
        // Arrange - Test verilerini ve beklenen davranışları ayarlıyoruz
        when(campaignRepository.save(any(Campaign.class))).thenReturn(campaign);

        // Act - Test edilecek metodu çağırıyoruz
        campaignService.add(createCampaignDto);

        // Assert - Beklenen sonuçları doğruluyoruz
        verify(campaignRepository, times(1)).save(any(Campaign.class));
    }

    @Test
    public void whenFindByIdCalledWithValidId_itShouldReturnCampaign() {
        // Arrange
        when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));

        // Act
        Optional<Campaign> result = campaignService.findById(campaignId);

        // Assert
        assertNotNull(result);
        assertEquals(campaign, result.get());
        verify(campaignRepository, times(1)).findById(campaignId);
    }
}
