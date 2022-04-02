package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.UserService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getall(){
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }
}
