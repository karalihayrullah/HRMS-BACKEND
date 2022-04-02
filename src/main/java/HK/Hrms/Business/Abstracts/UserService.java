package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    Result add(User user);
}
