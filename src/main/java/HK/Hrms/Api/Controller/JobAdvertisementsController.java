package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.JobAdvertisementService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.JobAdvertisement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")

public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public Result getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getbycompanyname")
    public DataResult sortByCompanyName(@RequestParam String companyName){
        return this.jobAdvertisementService.sortByCompanyName(companyName);
    }

    @GetMapping("/getbycreatedat")
    public DataResult<List<JobAdvertisement>> sortByCreatedAt(){
        return this.jobAdvertisementService.sortByCreatedAt();
    }
}
