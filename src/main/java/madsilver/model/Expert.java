package madsilver.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Expert extends Person {
    private ExpertStatus expertStatus;
    private double finalScore;
    @ManyToMany(mappedBy = "expertList",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<SubServices> subServicesList=new ArrayList<>();

}
