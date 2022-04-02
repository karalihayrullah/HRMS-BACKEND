package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
