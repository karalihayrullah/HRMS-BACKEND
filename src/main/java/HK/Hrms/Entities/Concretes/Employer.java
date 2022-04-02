package HK.Hrms.Entities.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer extends User{

    @Column(name="company_name")
    private String companyName;

    @Column(name= "phone_number")
    private String phoneNumber;
}
