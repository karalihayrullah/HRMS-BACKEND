package HK.Hrms.Business.Abstracts;



import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;

import HK.Hrms.Entities.Concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface PhotoService {
    Result Save(MultipartFile multipartFile) throws IOException;
    Result Delete(Integer id) throws IOException;
    DataResult<List<Photo>> getAll();

}
