package madsilver.model;

import jakarta.persistence.*;
import lombok.*;
import madsilver.base.entity.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orderOfCustomer")
public class Order extends BaseEntity<Long> {
  @ManyToOne
    private Customer customer;
  @ManyToOne
    private Expert expert;
    private double orderPrice;
    private OrderStatus orderStatus;
    private LocalDate orderRegisterDate;
    private LocalDate RequestedDateToDoOrder;
    private LocalDate ToDoOrderDate;
    private boolean doOrder;
    @OneToOne
    private Comment comment;



}
