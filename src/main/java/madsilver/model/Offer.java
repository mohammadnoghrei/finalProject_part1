package madsilver.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;
@Getter
@Setter
@Entity
@SuperBuilder
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Offer extends BaseEntity<Long> {

}
