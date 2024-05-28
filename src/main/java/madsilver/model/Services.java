package madsilver.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Services extends BaseEntity<Long> {
    @Column(nullable = false,unique = true)
    private String ServiceName;
    @OneToMany(mappedBy = "Services",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<SubServices> subServicesList=new ArrayList<>();

}
