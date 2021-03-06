package com.system.service.impl;

import com.system.po.SelectedCourseCustom;
import com.system.service.SelectedCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class SelectedCourseServiceImplTest {

    @Autowired
    private SelectedCourseService service;

    @Test
    public void findByCourseID() throws Exception {
        List<SelectedCourseCustom> list = service.findByCourseID(1);
        System.out.println(list);
    }
}