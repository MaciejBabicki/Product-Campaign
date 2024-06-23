package pl.maciej.campaign.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Field 'Name' can't be empty ")
    private String name;
    @NotBlank(message = "Field 'Keyword' can't be empty ")
    private String keyword;
    @NotNull(message = "Field 'Price' can't be null ")
    @Min(100)
    private BigDecimal price;
    @NotNull(message = "Field 'Fund' can't be null ")
    private BigDecimal fund;
    private boolean status;
    private String city;
    @NotNull(message = "Field 'Fund' can't be null ")
    private long radius;
}
