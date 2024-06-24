package pl.maciej.mapper;

import org.junit.jupiter.api.Test;
import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.mapper.CampaignMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CampaignMapperTests {
    @Test
    public void test_CampaignMapper_MappedProperly() {
        //given
        Campaign campaign = new Campaign();
        //when
        CampaignDto result = CampaignMapper.mapToCampaignDto(campaign);
        //then
        assertNotNull(result);
        assertEquals(campaign.getName(), result.getName());
    }

    @Test
    public void test_CampaignMapper_NullInput() {
        //given
        Campaign campaign = null;
        when(CampaignMapper.mapToCampaignDto(null)).thenThrow(NullPointerException.class);
        //when
        CampaignDto result = CampaignMapper.mapToCampaignDto(campaign);
        //then
        assertNull(result);
    }
}
