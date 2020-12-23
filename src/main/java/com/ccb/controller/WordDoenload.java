package com.ccb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
@Controller
@RequestMapping("/userInfo1")
public class WordDoenload {

    @RequestMapping("/classpathDownload")
    public void classpathDownload(String unitid, HttpServletRequest req, HttpServletResponse res) throws IOException {

        String filePath=req.getSession().getServletContext().getRealPath("/");
        String fileSaveName=filePath.substring(filePath.lastIndexOf("/")+1);
        File file = ResourceUtils.getFile(filePath+"upload/word/word1.docx");
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream bris=new BufferedInputStream(fis);

        OutputStream fos=res.getOutputStream();

        res.setCharacterEncoding("utf-8");
        res.setContentType("application/msword");
//        res.addHeader("Content-Disposition","attachment;filename=word.docx");
        res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("word.docx", "UTF-8"));

        byte b[]=new byte[1024];
        int len=0;
        while((len=bris.read(b))!=-1){
            fos.write(b,0,len);
        }
    }
}
