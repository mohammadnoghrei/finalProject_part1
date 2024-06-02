package madsilver.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order extends BaseEntity<Long> {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private SubServices subServices;
    private double customerOfferPrice;
    private double ExpertOfferPrice;
    private double finalPrice;
    private OrderStatus orderStatus;
    private LocalDate orderRegisterDate;
    private LocalDate RequestedDateToDoOrder;
    private LocalDate ToDoOrderDate;
    private boolean doOrder;
    @Range(min = 0, max = 5)
    private int rate;
    private String description;
    @OneToOne
    private Comment comment;
    private String address;



}
