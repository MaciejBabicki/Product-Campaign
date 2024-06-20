package pl.maciej.product;

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
    private String name;
    private String keyword;
    private BigDecimal price;
    private BigDecimal fund;
    private boolean open;
    private String city;
    private long radius;
}