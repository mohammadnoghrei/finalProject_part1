package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@ToString(callSuper = true)
public class Customer extends Person {
    @OneToMany
    private List<Order> orderList=new ArrayList<>();
    double cardBalance;

}
