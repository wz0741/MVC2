package com.xzk.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class FileController {

    @RequestMapping("/fileup")
    public String fileup(HttpServletRequest request,@RequestParam("file") MultipartFile file){
        //1.处理成服务器路径
        String realname = request.getRealPath("/upload");
        System.out.println(realname);
        //2.获取文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        //3.上传文件到服务器路径
        try {
            file.transferTo(new File(realname+"/"+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("file",originalFilename);
        return "uploadsuccess";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("file")String fileName,HttpServletRequest request) throws UnsupportedEncodingException ,IOException {
        System.out.println("开始文件下载");
        //1.转换服务器路径
        String realPath = request.getRealPath("/upload");
        String filePath=realPath+"/"+fileName;
        System.out.println(fileName);
        //2.设置请求头信息
        HttpHeaders headers = new HttpHeaders();
        //设置以流的方式响应
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置以弹窗的方式提示用户下载,attachment表示以附件形式发送文件
        headers.setContentDispositionFormData("attchment", URLEncoder.encode(fileName,"utf-8"));
        //3.创建文件
        File file= new File(filePath);

        //4.通过ResponseEntity类将文件返回
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>
                (FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);

        return entity;
    }
}
