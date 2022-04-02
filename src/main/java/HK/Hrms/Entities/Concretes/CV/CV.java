package HK.Hrms.Entities.Concretes.CV;

import HK.Hrms.Entities.Concretes.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;

    @JsonIgnore
    @OneToMany(mappedBy = "cv",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<University> universities;

    @JsonIgnore
    @OneToMany(mappedBy = "cv",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;


    @OneToOne(mappedBy = "cv",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Candidate candidate;
}
