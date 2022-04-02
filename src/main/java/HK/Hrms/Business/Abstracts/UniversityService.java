package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Entities.Concretes.CV.University;

import java.util.List;

public interface UniversityService {
    DataResult<List<University>> getAllByCv_IdOrderByEndDate(int cvId);
}
