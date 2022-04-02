package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends JpaRepository<Photo,Integer> {
    List<Photo> getAllByOrderById();
    Photo getById(Integer id);
}
