package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.EmployerService;
import HK.Hrms.Business.Abstracts.JobAdvertisementService;
import HK.Hrms.Core.Adapters.Abstracts.EmailCheckService;
import HK.Hrms.Core.Utilities.Results.*;
import HK.Hrms.DataAccess.Abstracts.EmployerDao;
import HK.Hrms.Entities.Concretes.Employer;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailCheckService emailCheckService;
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService, JobAdvertisementService jobAdvertisementService) {
        this.employerDao = employerDao;
        this.emailCheckService = emailCheckService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @Override
    public Result signUp(Employer employer) {
        if(!emailCheckService.isValid(employer.getEmail()).isSuccess()){
            return new ErrorResult("Bu email daha önce kullanıldı");
        }else{
            employerDao.save(employer);
            return new SuccessResult("Kayıt Başarılı!");
        }
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(),"Employerlar listelendi");
    }

    @Override
    public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @Override
    public Result deActiveJobAdvertisement(JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.deActiveJobAdvertisement(jobAdvertisement);
    }


}
