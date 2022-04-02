package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.EmployeeService;
import HK.Hrms.Core.Adapters.Abstracts.EmailCheckService;
import HK.Hrms.Core.Utilities.Results.*;
import HK.Hrms.DataAccess.Abstracts.EmployeeDao;
import HK.Hrms.Entities.Concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmailCheckService emailCheckService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmailCheckService emailCheckService) {
        this.employeeDao = employeeDao;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public Result signUp(Employee employee) {
        if(!emailCheckService.isValid(employee.getEmail()).isSuccess()){
            return new ErrorResult("Bu email daha önce kullanıldı");
        }else{
            employeeDao.save(employee);
            return new SuccessResult("Kayıt Başarılı!");
        }

    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(),"Employees listelendi");
    }
}
