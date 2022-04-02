package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.UserService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.UserDao;
import HK.Hrms.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(),"Kullanıcılar listelendi");
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

}
