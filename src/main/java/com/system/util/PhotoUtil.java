package com.system.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class PhotoUtil {

    public static String saveFile(MultipartFile fileData, String principle) {

        if (fileData != null && fileData.getOriginalFilename() != null
                && fileData.getOriginalFilename().length() > 0) {

            String filePath = "/home/liyonghao/Pictures/";
            String originalFilename = fileData.getOriginalFilename();

            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            File file = new File(filePath + newFileName);

            try {
                fileData.transferTo(file);
                return filePath + newFileName;
            } catch (Exception e) {}
        }
        return null;
    }

    public static void deleteFile(String oldPic) {
        File file = new File(oldPic);
        if (file.exists()) {
            file.delete();
        }
    }
}
