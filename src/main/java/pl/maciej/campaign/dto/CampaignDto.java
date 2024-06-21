package pl.maciej.campaign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDto {
    private long id;
    private String name;
    private String keyword;
    private BigDecimal price;
    private BigDecimal fund;
    private boolean status;
    private String city;
    private long radius;
}
