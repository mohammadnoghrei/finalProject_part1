package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import madsilver.base.entity.BaseEntity;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wallet extends BaseEntity<Long> {
    @OneToOne
    private Person person;
}
