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
public class Comment extends BaseEntity<Long> {
    private double score;
    private String description;
    @OneToOne
    private Order order;
}
