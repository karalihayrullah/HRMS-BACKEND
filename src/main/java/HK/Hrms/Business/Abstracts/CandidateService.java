package HK.Hrms.Business.Abstracts;


import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.CV.CV;
import HK.Hrms.Entities.Concretes.Candidate;

import java.util.List;


public interface CandidateService {
    Result signUp(Candidate candidate) throws Exception;
    DataResult<List<Candidate>> getAll();
    Result addCV(CV cv);
}
