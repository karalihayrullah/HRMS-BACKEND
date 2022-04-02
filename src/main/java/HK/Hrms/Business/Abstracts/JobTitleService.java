package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    Result add(JobTitle jobTitle);
    DataResult<List<JobTitle>> getAll();
}
