package HK.Hrms.Core.Adapters.Abstracts;

import HK.Hrms.Entities.Concretes.Candidate;


public interface VerifyService {
    boolean isValid(Candidate candidate) throws Exception;
}
