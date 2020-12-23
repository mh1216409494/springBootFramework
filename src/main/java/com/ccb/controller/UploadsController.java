package com.ccb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-15 14:04
 */
@Controller
@RequestMapping("/uploadDownload")
public class UploadsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadsController.class);

    @RequestMapping("/upload")
    public String upload() {
        return "html/upload";
    }

    @RequestMapping("/upload1")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        System.out.println("contentType----------"+file.getContentType());
        if(!file.getContentType().endsWith("officedocument.wordprocessingml.document") && !file.getContentType().endsWith("msword")){
            return "文件格式不符";
        }
        String fileName = file.getOriginalFilename();

		String filePath = request.getSession().getServletContext()
                		.getRealPath("/")+"upload/"+file.getOriginalFilename();

//        String filePath = "D:\\test111111\\test.txt";
        try {
            file.transferTo(new File(filePath));
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @RequestMapping("/multiUpload")
    public String multiUpload() {
        return "multiUpload";
    }

    @RequestMapping("/multiUpload1")
    @ResponseBody
    public String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "/Users/itinypocket/workspace/temp/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";

    }
}
