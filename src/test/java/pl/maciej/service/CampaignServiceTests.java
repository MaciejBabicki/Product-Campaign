package pl.maciej.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.repository.CampaignRepository;
import pl.maciej.campaign.service.CampaignService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CampaignServiceTests {
    Campaign campaign1 = new Campaign();
    Campaign campaign2 = new Campaign();
    long existingId = 1;
    @Mock
    private CampaignRepository repository;
    @InjectMocks
    private CampaignService campaignService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_CreateCampaign_CampaignCreated() {
        //given
        when(repository.save(any(Campaign.class))).thenReturn(campaign1);
        //when
        CampaignDto newCampaignDto = campaignService.createCampaign(campaign1);
        //then
        assertNotNull(newCampaignDto);
        assertEquals(newCampaignDto.getId(), campaign1.getId());
        verify(repository, times(1)).save(campaign1);
    }

    @Test
    void test_GetCampaigns_ListReturned() {
        //given
        List<Campaign> campaigns = Arrays.asList(campaign1, campaign2);
        when(repository.findAll()).thenReturn(campaigns);
        //when
        List<CampaignDto> result = campaignService.getCampaigns();
        //then
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void test_GetCampaign_CampaignReturned() {
        //given
        when(repository.findById(existingId)).thenReturn(Optional.of(campaign1));
        //when
        CampaignDto newCampaignDto = campaignService.getCampaign(existingId);
        //then
        assertNotNull(newCampaignDto);
    }

    @Test
    void test_UpdateCampaign_CampaignUpdated() {
        //given
        CampaignDto campaignDto = new CampaignDto();
        when(repository.findById(existingId)).thenReturn(Optional.of(campaign1));
        //when
        CampaignDto nerCampaignDto = campaignService.updateCampaign(existingId, campaignDto);
        //then
        assertNotNull(nerCampaignDto);
    }

    @Test
    void test_DeleteCampaign_CampaignDeleted() {
        //given
        when(repository.findById(existingId)).thenReturn(Optional.ofNullable(campaign1));
        //when
        campaignService.deleteCampaign(existingId);
        //then
        verify(repository, times(1)).findById(existingId);
        verify(repository, times(1)).deleteById(existingId);
    }
}
