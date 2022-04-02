package HK.Hrms.Entities.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","employees"})
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title_name")
    private String titleName;

    @OneToMany(mappedBy = "jobTitle")
    private List<Employee> employees;

    @OneToMany(mappedBy = "jobTitle")
    private List<JobAdvertisement> jobAdvertisements;
}
