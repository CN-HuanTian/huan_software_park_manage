package org.huantian.huan_software_park_manage.controller;

import org.huantian.huan_software_park_manage.pojo.Result;
import org.huantian.huan_software_park_manage.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/img")
    public Result uploadImg(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileName = null;
        if (originalFilename != null) {
            fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
        return Result.success(url);
    }
}
