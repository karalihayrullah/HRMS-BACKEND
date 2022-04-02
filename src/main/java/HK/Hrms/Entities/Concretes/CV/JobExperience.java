package HK.Hrms.Entities.Concretes.CV;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="position")
    private String position;
    @Column(name = "begin_date")
    private String beginDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne()
    @JoinColumn(name="job_expriences_id")
    private CV cv;
}
