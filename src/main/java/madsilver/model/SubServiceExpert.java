package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "subServiceexpert")
public class SubServiceExpert extends BaseEntity<Long> {
    @ManyToOne
    SubServices subServices;
    @ManyToOne
    Expert expert;
    LocalDate registerDate;
}
