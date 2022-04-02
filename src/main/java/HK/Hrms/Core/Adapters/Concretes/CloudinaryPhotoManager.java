package HK.Hrms.Core.Adapters.Concretes;

import HK.Hrms.Core.Adapters.Abstracts.PhotoCloudService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryPhotoManager implements PhotoCloudService {

    Cloudinary cloudinary;

    private Map<String,String> valuesMap = new HashMap<>();

    public CloudinaryPhotoManager() {
        valuesMap.put("cloud_name","hrmsphotos");
        valuesMap.put("api_key","415546819956462");
        valuesMap.put("api_secret","PXmTqBQH5bilNQkqgNUrz2SKlFk");
        cloudinary= new Cloudinary(valuesMap);
    }

    @Override
    public Map Upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    @Override
    public Map Delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file= new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
