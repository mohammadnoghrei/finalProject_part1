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
@ToString
public class SubServices extends BaseEntity<Long> {
    private String name;
    @ManyToOne
    private Services services;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Expert>expertList=new ArrayList<>();
    @OneToMany(mappedBy ="subServices" )
    private List<Order>orderList=new ArrayList<>();
    private double basePrice;
    private String description;
}
