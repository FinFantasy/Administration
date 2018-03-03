package com.system.service.impl;

import com.system.po.PagingVO;
import com.system.po.Student;
import com.system.po.StudentCustom;
import com.system.service.StudentService;
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
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void updateById() throws Exception {

        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setUserid(10004);
        studentCustom.setUsername("小拉");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = dateFormat.parse("1990-09-06");
        studentCustom.setBirthyear(date);

        studentCustom.setCollegeid(1);
        studentCustom.setSex("男");
        studentCustom.setGrade(new Date());
        studentService.updateById(10004, studentCustom);
    }

    @Test
    public void removeById() throws Exception {
        studentService.removeById(10004);
    }

    @Test
    public void findByPaging() throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(1);
        List<StudentCustom> list = studentService.findByPaging(pagingVO);
        System.out.println(list);
    }

    @Test
    public void save() throws Exception {
        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setUserid(10004);
        studentCustom.setUsername("小花");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("1996-09-02");
        studentCustom.setBirthyear(date);
        studentCustom.setCollegeid(1);
        studentCustom.setSex("男");
        studentCustom.setGrade(new Date());

        studentService.save(studentCustom);
    }

    @Test
    public void getCountStudent() throws Exception {
        int total = studentService.getCountStudent();
        System.out.println(total);
    }

    @Test
    public void findById() throws Exception {
        Student student = studentService.findById(10001);
        System.out.println(student);
    }

    @Test
    public void findByName() throws Exception {
        List<StudentCustom> list = studentService.findByName("小");
        System.out.println(list);
    }
}
