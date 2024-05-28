package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import madsilver.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubServices extends BaseEntity<Long> {
    @ManyToOne
    private Services services;
    @ManyToMany
    private List<Expert>expertList=new ArrayList<>();
    private double basePrice;
    private String description;
}
