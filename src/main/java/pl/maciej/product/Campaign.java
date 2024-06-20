package pl.maciej.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private String name;
    private String keyword;
    private BigDecimal price;
    private BigDecimal fund;
    private boolean open;
    private String city;
    private long radius;
}
