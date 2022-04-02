package HK.Hrms.Core.Adapters.Concretes;

import HK.Hrms.Core.Adapters.Abstracts.NationalityIdCheckService;
import HK.Hrms.Core.Utilities.Results.ErrorResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalityIdChechManager implements NationalityIdCheckService {

    private CandidateDao candidatedao;

    @Autowired
    public NationalityIdChechManager(CandidateDao candidatedao) {
        this.candidatedao = candidatedao;
    }

    @Override
    public Result isValid(String nationalityId) {
        if(candidatedao.findByNationalityId(nationalityId)==null){
            return  new SuccessResult();
        }
        else
            return new ErrorResult();
    }
}
