package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.UniversityService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Entities.Concretes.CV.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
    private UniversityService universityService;

    @Autowired
    public UniversitiesController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("getAllByCv_IdOrderByEndDate")
    public DataResult<List<University>> getAllByCv_IdOrderByEndDate(@RequestParam int cvId) {
        return this.universityService.getAllByCv_IdOrderByEndDate(cvId);
    }
}
