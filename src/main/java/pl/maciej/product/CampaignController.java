package pl.maciej.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public CampaignDto getCampaign(@PathVariable("id") long id){
        return service.getCampaign(id);
    }
    @PutMapping("/{id}")
    public CampaignDto updateCampaign(@PathVariable("id") long id, @RequestBody CampaignDto campaignDto){
        return service.updateCampaign(id, campaignDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable("id") long id){
        service.deleteCampaign(id);
    }
}