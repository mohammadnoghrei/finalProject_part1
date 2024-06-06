package madsilver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public class Offer extends BaseEntity<Long> {
    @ManyToOne
    @NotNull
    private Order order;
    @ManyToMany
    private List<Expert>expertList=new ArrayList<>();
    LocalDate sendOfferDate;
    boolean confirmed;




}
