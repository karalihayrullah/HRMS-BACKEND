package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
