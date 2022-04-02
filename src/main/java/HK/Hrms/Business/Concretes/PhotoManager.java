package HK.Hrms.Business.Concretes;

import HK.Hrms.Business.Abstracts.PhotoService;
import HK.Hrms.Core.Adapters.Abstracts.PhotoCloudService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Core.Utilities.Results.SuccessDataResult;
import HK.Hrms.Core.Utilities.Results.SuccessResult;
import HK.Hrms.DataAccess.Abstracts.PhotoDao;
import HK.Hrms.Entities.Concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements  PhotoService {

    @Autowired
    PhotoDao photoDao;

    @Autowired
    PhotoCloudService photoCloudService;
    

    @Override
    public Result Save(MultipartFile multipartFile) throws IOException {
        Map result = photoCloudService.Upload(multipartFile);
        this.photoDao.save(new Photo((String)result.get("original_filename"),
                (String)result.get("url"),
                (String)result.get("public_id")));
        return new SuccessResult("Foto Kaydedildi");
    }

    @Override
    public Result Delete(Integer id) throws IOException {
        Photo photo= photoDao.getById(id);
        photoCloudService.Delete(photo.getPhotoId());
        this.photoDao.deleteById(photo.getId());
        return new SuccessResult("Foto Silindi.");
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<>(this.photoDao.getAllByOrderById());
    }
}
