package HK.Hrms.Core.Adapters.Abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface PhotoCloudService {
    Map Upload(MultipartFile multipartFile) throws IOException;
    Map Delete(String id) throws IOException;
}
