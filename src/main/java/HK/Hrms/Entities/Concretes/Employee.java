package HK.Hrms.Entities.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "job_title_id",referencedColumnName = "id")
    private JobTitle jobTitle;
}
