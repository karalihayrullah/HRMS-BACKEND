package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Entities.Concretes.CV.CV;
import HK.Hrms.Entities.Concretes.CV.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVDao extends JpaRepository<CV,Integer> {

}
