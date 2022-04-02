package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.JobTitleService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.JobTitleDao;
import HK.Hrms.Entities.Concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Ünvan eklendi");
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {

        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Ünvanlar listlendi");
    }
}
