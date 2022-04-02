package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.JobAdvertisementService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.JobAdvertisementDao;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("iş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> sortByCompanyName(String companyName) {
        Sort sort = Sort.by(Sort.Direction.ASC,"companyName");
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAllByCompanyName(companyName),"İlanlar Şirket Adına Göre Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> sortByCreatedAt() {
        Sort sort = Sort.by(Sort.Direction.ASC,"createdAt");
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(sort),"İlanlar Oluşturulma Zamanına Göre Listelendi");
    }

    @Override
    public Result deActiveJobAdvertisement(JobAdvertisement jobAdvertisement) {
        jobAdvertisement.setActive(false);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Pasif Hale Getirildi");
    }
}
