package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.EmployerService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.Employer;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/signup")
    public Result signUp(@RequestBody Employer employer){
        return this.employerService.signUp(employer);
    }

    @PostMapping("/addjobadvertisement")
    public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return this.employerService.addJobAdvertisement(jobAdvertisement);
    }

    @PutMapping("deActiveJobAdvertisement")
    public Result deActiveJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return this.employerService.deActiveJobAdvertisement(jobAdvertisement);
    }
}
