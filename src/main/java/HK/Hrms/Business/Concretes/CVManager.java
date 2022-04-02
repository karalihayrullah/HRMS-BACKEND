package HK.Hrms.Business.Concretes;
import HK.Hrms.Business.Abstracts.CVService;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.CVDao;
import HK.Hrms.Entities.Concretes.CV.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CVManager implements CVService{

    @Autowired
    private CVDao cvDao;

    @Override
    public Result add(CV cv) {
        cvDao.save(cv);
        return new SuccessResult("CV Eklendi");
    }
}
