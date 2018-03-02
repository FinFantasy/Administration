package com.system.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    全局异常处理器
 *    springmvc提供一个HandlerExceptionResolver接口
 *      只要实现该接口，并配置到spring 容器里，该类就能
 *      成为默认全局异常处理类
 *
 *   全局异常处理器只有一个，配置多个也没用。
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();

        CustomException customException;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else if (e instanceof UnknownAccountException) {
            customException = new CustomException("没有该用户");
        } else if (e instanceof IncorrectCredentialsException) {
            customException = new CustomException("密码错误");
        } else {
            customException = new CustomException("未知错误");
        }

        String message = customException.getMessage();

        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
