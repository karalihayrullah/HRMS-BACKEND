package HK.Hrms.DataAccess.Abstracts;

import HK.Hrms.Entities.Concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findAllByCompanyName(String companyName);
}
