package HK.Hrms.DataAccess.Abstracts;


import HK.Hrms.Entities.Concretes.CV.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UniversityDao extends JpaRepository<University,Integer> {
    List<University> getAllByCv_Id(int cvId);
}
