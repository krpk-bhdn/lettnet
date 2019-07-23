package com.krpk.lettnet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    private void checkOrCreateUploadDir() {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String resultFilename = null;
        if (file != null && !file.isEmpty()) {
            checkOrCreateUploadDir();

            resultFilename = file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
        }

        return resultFilename;
    }
}
