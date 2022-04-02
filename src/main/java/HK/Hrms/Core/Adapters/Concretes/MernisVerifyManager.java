package HK.Hrms.Core.Adapters.Concretes;

import HK.Hrms.Core.Adapters.Abstracts.VerifyService;
import HK.Hrms.Entities.Concretes.Candidate;
import HK.Hrms.MernisReference.BQVKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MernisVerifyManager implements VerifyService {

    BQVKPSPublicSoap mernis=new BQVKPSPublicSoap();

    @Override
    public boolean isValid(Candidate candidate) throws Exception {

        return mernis.TCKimlikNoDogrula(new Long(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), candidate.getBirthYear());
    }
}
