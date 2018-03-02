package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.Userlogin;
import com.system.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class RestPasswordController {

    @Resource(name = "userLoginServiceImpl")
    private UserLoginService userLoginService;

    @Autowired
    private PasswordService passwordService;

    // 本账户密码重置
    @RequestMapping(value = "/passwordRest", method = {RequestMethod.POST})
    public String passwordRest(String oldPassword, String password1) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        Userlogin userlogin = userLoginService.findByName(username);

        if (!passwordService.passwordsMatch(oldPassword, userlogin.getPassword())) {
            throw new CustomException("旧密码不正确");
        } else {
            userlogin.setPassword(passwordService.encryptPassword(password1));
            userLoginService.updateByName(username, userlogin);
        }

        return "redirect:/logout";
    }
}
