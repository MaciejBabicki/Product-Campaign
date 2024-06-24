package pl.maciej.campaign.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.maciej.campaign.dto.CampaignDto;
import pl.maciej.campaign.entity.Campaign;
import pl.maciej.campaign.service.CampaignService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService service;

    @PostMapping
    public CampaignDto createCampaign(@Valid @RequestBody Campaign campaign) {
        return service.createCampaign(campaign);
    }

    @GetMapping
    public List<CampaignDto> getCampaigns() {
        return service.getCampaigns();
    }

    @GetMapping("/{id}")
    public CampaignDto getCampaign(@PathVariable("id") long id) {
        return service.getCampaign(id);
    }

    @PutMapping("/{id}")
    public CampaignDto updateCampaign(@PathVariable("id") long id, @RequestBody CampaignDto campaignDto) {
        return service.updateCampaign(id, campaignDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCampaign(@PathVariable("id") long id) {
        service.deleteCampaign(id);
    }
}
