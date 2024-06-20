package pl.maciej.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository repository;
    private final CampaignMapper mapper;

    public CampaignDto createCampaign(Campaign campaign) {
        CampaignDto campaignDto = CampaignMapper.mapToCampaignDto(campaign);
        repository.save(campaign);
        return campaignDto;
    }

    public List<CampaignDto> getCampaigns() {
        List<Campaign> campaigns = repository.findAll();
        return campaigns.stream().
                map(CampaignMapper::mapToCampaignDto).
                collect(Collectors.toList());
    }
}
