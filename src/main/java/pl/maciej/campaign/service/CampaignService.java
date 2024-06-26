package pl.maciej.campaign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.exception.ResourceNotFoundException;
import pl.maciej.campaign.mapper.CampaignMapper;
import pl.maciej.campaign.repository.CampaignRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository repository;

    public CampaignDto createCampaign(Campaign campaign) {
        CampaignDto campaignDto = CampaignMapper.mapToCampaignDto(campaign);
        repository.save(campaign);
        return campaignDto;
    }

    public List<CampaignDto> getCampaigns() {
        List<Campaign> campaigns = repository.findAll();
        return campaigns.stream().map(CampaignMapper::mapToCampaignDto).collect(Collectors.toList());
    }

    public CampaignDto getCampaign(long id) {
        Campaign campaign = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return CampaignMapper.mapToCampaignDto(campaign);
    }

    public CampaignDto updateCampaign(long id, CampaignDto updatedCampaign) {
        Campaign campaign = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        campaign.setName(updatedCampaign.getName());
        campaign.setKeyword(updatedCampaign.getKeyword());
        campaign.setPrice(updatedCampaign.getPrice());
        campaign.setFund(updatedCampaign.getFund());
        campaign.setStatus(updatedCampaign.isStatus());
        campaign.setCity(updatedCampaign.getCity());
        campaign.setRadius(updatedCampaign.getRadius());
        repository.save(campaign);
        return CampaignMapper.mapToCampaignDto(campaign);
    }

    public void deleteCampaign(long id) {
        repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        repository.deleteById(id);
    }
}
