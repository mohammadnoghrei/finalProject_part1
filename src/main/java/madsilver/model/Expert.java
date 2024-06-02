package madsilver.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;


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
    @Range(min = 0,max = 5)
    private double finalScore;
    private byte[] image;
    @ManyToMany(mappedBy = "expertList",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<SubServices> subServicesList=new ArrayList<>();
    double cardBalance;
}
