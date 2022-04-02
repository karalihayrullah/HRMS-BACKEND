package HK.Hrms.Entities.Concretes;

import ch.qos.logback.classic.pattern.DateConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="details")
    private String details;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name="created_at")
    private LocalDate createdAt=LocalDate.now();

    @Column(name="application_deadline")
    private String applicationDeadline;

    @Column(name="number_of_position")
    private int numberOfPosition;

    @Column(name="is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name= "job_title_id")
    private JobTitle jobTitle;

}
