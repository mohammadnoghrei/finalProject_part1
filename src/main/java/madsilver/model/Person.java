package madsilver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;
import madsilver.base.entity.BaseEntity;
import madsilver.utility.ValidationCode;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person extends BaseEntity<Long> {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @Column(unique = true,nullable = false)
    private String username;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;
    @Column(unique=true,nullable = false)
    @ValidationCode
    private String nationCode;
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    private LocalDate registerDate;

}
