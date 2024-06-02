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
@ToString
public class Admin extends Person {
    private String grade;

//    public class AdminBuilder extends PersonBuilder<AdminBuilder>(){
//        public AdminBuilder(PersonBuilder<AdminBuilder> builder){
//            super(builder);
//        }
//        public AdminBuilder adminBuilder(String adminId){
//            thid.adminId = adminId;
//             return this;}
//    }
}
