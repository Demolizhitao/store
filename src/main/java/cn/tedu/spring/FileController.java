package cn.tedu.spring;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class FileController {

    CommonsMultipartResolver cmr;
    
    @RequestMapping(value="upload.do",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult handleUpload(
            HttpServletRequest request,
            @RequestParam("file") MultipartFile file) 
                    throws IllegalStateException, IOException{
        String path = request.getServletContext().getRealPath("upload");
        //检查上传的文件是否为空
//        if(file.isEmpty()){
//          
//        }
        //获取文件类型
        String contentType = file.getContentType();
        //限制文件上传类型
//        if("image/png".equals(contentType)){
//            
//        }
        System.out.println(contentType);
        //获取文件大小
        Long size = file.getSize();
        System.out.println(size);
        
        //上传文件夹 
        File parent = new File(path);
        if(!parent.exists()){
            parent.mkdirs();
        }
        
        //上传的文件名
       String originalFilename = 
               file.getOriginalFilename();//获取原来文件名
       //获取原扩展名
       String suffix = "";
       Integer index = originalFilename.lastIndexOf(".");
       if(index != -1){
         suffix = originalFilename.substring(index
                   );
       }
               
       
        String child =UUID.randomUUID()+suffix;
        
        //保存用户上传的文件
        File dest = new File(parent,child);
        file.transferTo(dest);
        return new JsonResult(200); 
    }
}
