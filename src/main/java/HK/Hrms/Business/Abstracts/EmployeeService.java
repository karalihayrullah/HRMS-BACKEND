package HK.Hrms.Business.Abstracts;

import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.Employee;

import java.util.List;

public interface EmployeeService {
    Result signUp(Employee employee);
    DataResult<List<Employee>> getAll();
}
