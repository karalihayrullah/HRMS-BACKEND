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
@Table(name = "universities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="university_name")
    private String universityName;

    @Column(name = "begin_date")
    private String beginDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne()
    @JoinColumn(name="universities_id")
    private CV cv;
}
