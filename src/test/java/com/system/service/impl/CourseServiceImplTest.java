package com.system.service.impl;

import com.system.po.CourseCustom;
import com.system.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml"})
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void findById() throws Exception {
        CourseCustom courseCustom = courseService.findById(1);
        System.out.println(courseCustom);
    }

    @Test
    public void findByTeacherID() throws Exception {
        List<CourseCustom> list = courseService.findByTeacherID(1001);
    }
}