package softuni.exam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    @Positive
    @Column(nullable = false)
    private Double price;

    @Size(min = 5)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String	description;

    @Column(nullable = false)
    private Boolean	hasGoldStatus;

    @Column(nullable = false)
    private LocalDateTime addedOn;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;



    @ManyToMany
    @JoinTable(name = "offers_pictures", joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private List<Picture> pictures;
}
