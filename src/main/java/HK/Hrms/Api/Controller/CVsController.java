package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.CVService;
import HK.Hrms.Business.Concretes.CVManager;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.CV.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvs")
public class CVsController {
    @Autowired
    private CVService cvService;

    @PostMapping("/add")
    private Result add(@RequestBody CV cv){
        return this.cvService.add(cv);
    }
}
