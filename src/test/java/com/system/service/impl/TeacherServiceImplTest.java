package com.system.service.impl;

import com.system.po.PagingVO;
import com.system.po.TeacherCustom;
import com.system.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class TeacherServiceImplTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void updateById() throws Exception {
        TeacherCustom teacherCustom = new TeacherCustom();
        teacherCustom.setUserid(1003);
        teacherCustom.setUsername("软老师");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");

        Date date = dateFormat.parse("1996-09-02");
        teacherCustom.setBirthyear(date);

        teacherCustom.setCollegeid(1);
        teacherCustom.setSex("男");
        teacherCustom.setGrade(new Date());
        teacherCustom.setTitle("助教");
        teacherCustom.setDegree("硕士");

        teacherService.updateById(1003, teacherCustom);
    }

    @Test
    public void removeById() throws Exception {
        //teacherService.removeById(1003);  //需先删除该名老师所教授课程
    }

    @Test
    public void findByPaging() throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(1);
        List<TeacherCustom> list = teacherService.findByPaging(pagingVO);
        System.out.println(list);
    }

    @Test
    public void save() throws Exception {
        TeacherCustom teacherCustom = new TeacherCustom();
        teacherCustom.setUserid(1010);
        teacherCustom.setUsername("陈老师");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");

        Date date = dateFormat.parse("1996-09-02");
        teacherCustom.setBirthyear(date);

        teacherCustom.setCollegeid(1);
        teacherCustom.setSex("男");
        teacherCustom.setGrade(new Date());
        teacherCustom.setTitle("助教");

        teacherService.save(teacherCustom);
    }

    @Test
    public void getCountTeacher() throws Exception {
        int total = teacherService.getCountTeacher();
        System.out.println(total);
    }

    @Test
    public void findById() throws Exception {

        TeacherCustom teacherCustom = teacherService.findById(1001);
        System.out.println(teacherCustom);
    }

    @Test
    public void findByName() throws Exception {
        List<TeacherCustom> list = teacherService.findByName("老师");
        System.out.println(list);
    }

    @Test
    public void findAll() throws Exception {
        List<TeacherCustom> list = teacherService.findAll();
        System.out.println();
    }
}
