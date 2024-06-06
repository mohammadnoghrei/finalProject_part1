package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;
@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public class Admin extends Person {
    private String grade;

}
