package com.system.controller;

import com.system.po.Userlogin;
import com.system.util.RedirectUtil;
import com.system.vcode.Captcha;
import com.system.vcode.GifCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        //System.out.println(subject.hasRole("admin"));
        return RedirectUtil.redirect(subject);
    }

    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(Userlogin userlogin, String vcode, Boolean rememberMe, Model model) throws Exception {

        if (vcode == null || vcode.equals("")) {
            model.addAttribute("message", "验证码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        vcode = vcode.toLowerCase();
        String v = (String) session.getAttribute("_code");
        session.removeAttribute("_code");
        if (!vcode.equals(v)) {
            model.addAttribute("message", "验证码错误！");
            return "login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(userlogin.getUsername(),
                userlogin.getPassword(), rememberMe == null ? false : rememberMe);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            if (e instanceof ExcessiveAttemptsException) {
                model.addAttribute("message", "密码错误次数过多，请一小后再试");
            } else if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException) {
                model.addAttribute("message", "帐号或密码错误");
            } else {
                model.addAttribute("message", "未知错误");
            }
        } catch (Exception e) {}

        return RedirectUtil.redirect(subject);
    }

    @RequestMapping(value = "/getGifCode", method = RequestMethod.GET)
    public void getGifCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            Captcha captcha = new GifCaptcha(146, 33, 4);
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);

            session.setAttribute("_code", captcha.text().toLowerCase());
        } catch (Exception e) {
            System.out.println("获取验证码异常："+e.getMessage());
        }
    }
}
