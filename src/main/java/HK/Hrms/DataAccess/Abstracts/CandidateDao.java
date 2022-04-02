package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByNationalityId(String nationalityId);
}
