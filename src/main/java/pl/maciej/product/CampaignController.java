package pl.maciej.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("campaign")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService service;

    @PostMapping
    public CampaignDto createCampaign(){
        Campaign campaign = new Campaign();
        return service.createCampaign(campaign);
    }

    @GetMapping
    public List<CampaignDto> getCampaigns(){
        return service.getCampaigns();
    }
}
