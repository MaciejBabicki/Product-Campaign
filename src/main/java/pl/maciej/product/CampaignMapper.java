package pl.maciej.product;

import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {
    public static CampaignDto mapToCampaignDto(Campaign campaign) {
        return new CampaignDto(
                campaign.getName(),
                campaign.getKeyword(),
                campaign.getPrice(),
                campaign.getFund(),
                campaign.isOpen(),
                campaign.getCity(),
                campaign.getRadius()
        );
    }
}
