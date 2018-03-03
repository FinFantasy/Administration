package com.system.controller;

import com.system.service.UserLoginService;
import com.system.util.PhotoUtil;
import com.system.util.RedirectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class PictureController {

    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    @RequestMapping(value = "/getProfilePhoto", method = RequestMethod.GET)
    public void getProfilePhoto(HttpServletResponse response) {

        //手动更改
        String defaultPic = "/home/liyonghao/Pictures/default.jpeg";

        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        String path = userLoginService.findPicPathByName(userName);
        FileInputStream in = null;
        OutputStream os = null;
        try {
            if (path == null) {
                path = defaultPic;
            }
            in = new FileInputStream(path);
            os = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            int count = 0;
            byte[] buffer = new byte[1024*8];
            while ((count = in.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            in.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadFile() {
        return "common/fileUpload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(MultipartFile pictureFile) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();

        if (pictureFile != null) {
            String oldPath = userLoginService.findPicPathByName(userName);

            String path = PhotoUtil.saveFile(pictureFile, userName);
            if (path != null) {
                if (oldPath != null) {
                    PhotoUtil.deleteFile(oldPath);
                }
                userLoginService.savePicPathByName(userName, path);
            }
        }
        return RedirectUtil.redirect(subject);
    }
}
