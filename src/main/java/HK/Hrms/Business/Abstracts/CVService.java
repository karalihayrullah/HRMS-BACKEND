package HK.Hrms.Business.Abstracts;


import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.CV.CV;


public interface CVService {
    Result add(CV cv);
}
