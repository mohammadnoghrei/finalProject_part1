package madsilver.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public class SubServices extends BaseEntity<Long> {
    private String name;
    @ManyToOne
    private Services services;
    private double basePrice;
    private String description;
    @OneToMany( mappedBy = "subServices",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<SubServiceExpert>subServiceExperts=new ArrayList<>();
    @OneToMany(mappedBy ="subServices" ,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Order>orderList=new ArrayList<>();

}
