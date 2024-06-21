package pl.maciej.campaign.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String keyword;
    @Min(100)
    private BigDecimal price;
    @NotBlank
    private BigDecimal fund;
    private boolean status;
    private String city;
    private long radius;
}
