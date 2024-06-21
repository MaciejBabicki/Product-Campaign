package pl.maciej.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maciej.campaign.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
