package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> sortByCompanyName(String companyName);
    DataResult<List<JobAdvertisement>> sortByCreatedAt();
    Result deActiveJobAdvertisement(JobAdvertisement jobAdvertisement);
}
