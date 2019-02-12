package cn.tedu.spring;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class FileController {

    CommonsMultipartResolver cmr;
    
    @RequestMapping(value="upload.do",method=RequestMethod.POST)
    public String handleUpload(
            @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
        //保存用户上传的文件
        File dest = new File("d:/1.txt");
        file.transferTo(dest);
        return "OK";
    }
}
