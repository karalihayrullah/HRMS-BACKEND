package HK.Hrms.Entities.Concretes;

import HK.Hrms.Entities.Concretes.CV.CV;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nationality_id")
    private String nationalityId;

    @Column(name="birth_year")
    private int birthYear;

    @JsonIgnore
    @OneToOne(
    orphanRemoval = true,
    cascade = CascadeType.ALL)
    @JoinColumn(name="cvs_id",referencedColumnName = "id")
    private CV cv;

}
