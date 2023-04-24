package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private ApartmentType apartmentType;

    @DecimalMin("40.00")
    @Column(nullable = false)
    private Double area;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;
}
