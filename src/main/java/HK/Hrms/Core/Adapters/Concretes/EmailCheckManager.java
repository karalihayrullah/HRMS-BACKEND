package HK.Hrms.Core.Adapters.Concretes;

import HK.Hrms.Core.Adapters.Abstracts.EmailCheckService;
import HK.Hrms.Core.Utilities.Results.ErrorResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmailCheckManager implements EmailCheckService {

    UserDao userDao;

    @Autowired
    public EmailCheckManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result isValid(String email) {
        if(userDao.findByEmail(email)==null){
                return new SuccessResult();
            }
        else
            return new ErrorResult();

        }


    }
