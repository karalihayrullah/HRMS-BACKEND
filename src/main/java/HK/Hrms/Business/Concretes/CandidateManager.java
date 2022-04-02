package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.CVService;
import HK.Hrms.Business.Abstracts.CandidateService;
import HK.Hrms.Core.Adapters.Abstracts.EmailCheckService;
import HK.Hrms.Core.Adapters.Abstracts.NationalityIdCheckService;
import HK.Hrms.Core.Adapters.Abstracts.VerifyService;
import HK.Hrms.Core.Utilities.Results.*;
import HK.Hrms.DataAccess.Abstracts.CandidateDao;
import HK.Hrms.Entities.Concretes.CV.CV;
import HK.Hrms.Entities.Concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateManager implements CandidateService {


    CandidateDao candidateDao;
    VerifyService verifyService;
    EmailCheckService emailCheckService;
    NationalityIdCheckService nationalityIdCheckService;
    CVService cvService;


    @Autowired
    public CandidateManager(CVService cvService,NationalityIdCheckService nationalityIdCheckService, EmailCheckService emailCheckService, CandidateDao candidateDao, VerifyService verifyService) {
        this.cvService=cvService;
        this.nationalityIdCheckService=nationalityIdCheckService;
        this.emailCheckService=emailCheckService;
        this.candidateDao = candidateDao;
        this.verifyService = verifyService;
    }




    @Override
    public Result signUp(Candidate candidate) throws Exception {
        if(verifyService.isValid(candidate)==false) {
            return new ErrorResult("Kimlik bilgileri hatalı ");
        }
        else if(verifyService.isValid(candidate)==true){
            if(emailCheckService.isValid(candidate.getEmail()).isSuccess()){
               if(nationalityIdCheckService.isValid(candidate.getNationalityId()).isSuccess()){
                   candidateDao.save(candidate);
                   return new SuccessResult("Kayıt Başarılı");
               }
               else{
                   return  new ErrorResult("Bu kimliğe ait kayıt bulunmaktadır");
               }
            }
            else
                return new ErrorResult("Bu email daha önce kullanıldı");
        }
        else
            return new ErrorResult("Girilen bilgiler hatalı veya eksik");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll(),"Adaylar listelendi");
    }

    @Override
    public Result addCV(CV cv) {
        cvService.add(cv);
        return new SuccessResult("CV Eklendi");
    }

}
