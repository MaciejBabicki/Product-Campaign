package pl.maciej.campaign.mapper;

import org.springframework.stereotype.Component;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.dto.CampaignDto;

@Component
public class CampaignMapper {
    public static CampaignDto mapToCampaignDto(Campaign campaign) {
        return new CampaignDto(
                campaign.getId(),
                campaign.getName(),
                campaign.getKeyword(),
                campaign.getPrice(),
                campaign.getFund(),
                campaign.isStatus(),
                campaign.getCity(),
                campaign.getRadius()
        );
    }
}
