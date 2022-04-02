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
@Table(name="languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="language_name")
    private String languageName;


    @Column(name="level")
    private int level;

    @ManyToOne()
    @JoinColumn(name="languages_id")
    private CV cv;
}
