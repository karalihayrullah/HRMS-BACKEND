package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.Candidate;
import HK.Hrms.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
