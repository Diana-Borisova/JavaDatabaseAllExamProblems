package softuni.exam.models.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country extends BaseEntity{
    @Size(min = 2, max = 60)
    @Column(nullable = false, unique = true)
    private String countryName;

    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String currency;
}