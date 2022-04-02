package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
}
