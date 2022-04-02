package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.EmployeeService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Entities.Concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    private DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }

    @PostMapping("/signup")
    private Result signUp(@RequestBody Employee employee){
        return this.employeeService.signUp(employee);
    }
}
