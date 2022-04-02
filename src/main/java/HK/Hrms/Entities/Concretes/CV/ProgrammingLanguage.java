package HK.Hrms.Entities.Concretes.CV;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "programming_languages_id")
    private CV cv;
}
