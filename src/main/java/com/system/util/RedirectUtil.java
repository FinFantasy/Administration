package com.system.util;

import org.apache.shiro.subject.Subject;

public class RedirectUtil {

    public static String redirect(Subject subject) {
        if (subject.isAuthenticated() || subject.isRemembered()) {
            if (subject.hasRole("admin")) {
                return "redirect:/admin/showStudent";
            } else if (subject.hasRole("teacher")) {
                return "redirect:/teacher/showCourse";
            } else if (subject.hasRole("student")) {
                return "redirect:/student/showCourse";
            }
        }
        return "login";
    }
}
