package HK.Hrms.Api.Controller;

import HK.Hrms.Business.Abstracts.PhotoService;
import HK.Hrms.Core.Utilities.Results.DataResult;
import HK.Hrms.Core.Utilities.Results.Result;
import HK.Hrms.Entities.Concretes.Photo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/getAll")
    public DataResult<List<Photo>> getAll(){
        return this.photoService.getAll();
    }

    @SneakyThrows
    @PostMapping("/save")
    public Result save(@RequestParam MultipartFile multipartFile) throws IOException {
        return this.photoService.Save(multipartFile);
    }

    @SneakyThrows
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id) throws IOException {
        return this.photoService.Delete(id);
    }
}
