package pl.maciej.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.service.CampaignService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles
public class CampaignControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CampaignService campaignService;
    Campaign campaign = new Campaign();

    @Test
    void crateCampaign() throws Exception{
        Campaign campaign = new Campaign();
        campaign.setName("test");
        campaign.setKeyword("test");
        campaign.setPrice(BigDecimal.valueOf(250));
        campaign.setFund(BigDecimal.valueOf(1000));
        campaign.setStatus(false);
        campaign.setCity("test");
        campaign.setRadius(3);

        mockMvc.perform(post("/campaigns")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(campaign)))
                .andExpect(status().isOk());
    }
    @Test
    public void createCampaign_CreatedCampaign() throws Exception {
        //given
        CampaignDto campaignDto = new CampaignDto();
        //when
        when(campaignService.createCampaign(campaign)).thenReturn(campaignDto);
        //then
        mockMvc.perform(post("/campaign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(campaignDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(campaignDto.getName()));
    }

    @Test
    public void test_CreateCampaign_InvalidRequestBody() throws Exception {
        //given
        String invalidRequestBody = "invalid request body";
        //then
        mockMvc.perform(post("/campaign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_GetCampaigns_ListReturned() throws Exception {
        //given
        List<CampaignDto> campaignDtos = Arrays.asList(
                new CampaignDto(),
                new CampaignDto()
        );
        when(campaignService.getCampaigns()).thenReturn(campaignDtos);
        //then
        mockMvc.perform(get("/campaigns")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("/$.campaigns", hasSize(2)));
    }

    @Test
    void test_getCampaignById_CampaignReturned() throws Exception {
        //given
        long campaignId = 1L;
        CampaignDto campaignDto = new CampaignDto();
        //when
        when(campaignService.getCampaign(campaignId)).thenReturn(campaignDto);
        //then
        mockMvc.perform(get("/campaings/{id}", campaignId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(campaignDto.getName()));
    }
}
