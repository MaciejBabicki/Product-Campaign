package pl.maciej.campaign.mapper;

import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;

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
