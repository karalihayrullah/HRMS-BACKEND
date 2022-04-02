package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.CandidateService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.CV.CV;
import HK.Hrms.Entities.Concretes.Candidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

    CandidateService candidateService;

    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/signup")
    public Result signUp(@RequestBody Candidate candidate) throws Exception {
        return this.candidateService.signUp(candidate);
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @PostMapping("/addCV")
    public Result addCV(@RequestBody CV cv){
        return this.candidateService.addCV(cv);
    }
}
