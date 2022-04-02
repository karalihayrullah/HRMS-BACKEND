package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.UniversityService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.DataAccess.Abstracts.UniversityDao;
import HK.Hrms.Entities.Concretes.CV.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    private UniversityDao universityDao;

    @Autowired
    public UniversityManager(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    @Override
    public DataResult<List<University>> getAllByCv_IdOrderByEndDate(int cvId) {
        return new SuccessDataResult<>(this.universityDao.getAllByCv_Id(cvId),"üniversiteler getirildi");
    }
}
