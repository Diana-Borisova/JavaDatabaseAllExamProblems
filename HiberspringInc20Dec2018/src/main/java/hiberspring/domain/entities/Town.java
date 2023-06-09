package hiberspring.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long population;

    @OneToMany
    @JoinColumn(name = "town_id")
    private List<Branch> branches;
}
