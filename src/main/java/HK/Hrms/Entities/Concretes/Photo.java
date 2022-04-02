package HK.Hrms.Entities.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String photoUrl;
    private String photoId;

    public Photo(String name,String photoUrl,String photoId){
        this.name=name;
        this.photoId=photoId;
        this.photoUrl=photoUrl;
    }
}
