package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.Employer;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import java.util.List;

public interface EmployerService {
    Result signUp(Employer employer);
    DataResult<List<Employer>> getAll();
    Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
    Result deActiveJobAdvertisement(JobAdvertisement jobAdvertisement);
}
