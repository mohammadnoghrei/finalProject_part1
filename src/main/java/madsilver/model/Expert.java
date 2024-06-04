package madsilver.model;

import jakarta.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private ExpertStatus expertStatus;
    @Range(min = 0,max = 5)
    private double avgScore;
    private byte[] image;
    @ManyToMany(mappedBy = "expertList",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<SubServices> subServicesList=new ArrayList<>();
    @ManyToMany(mappedBy = "expertList",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Offer>offerList=new ArrayList<>();
    double cardBalance;
}
