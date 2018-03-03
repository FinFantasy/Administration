package com.system.mapper;

import com.system.po.Student;
import com.system.po.StudentExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentMapperTest {


    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    }

    @Test
    public void selectByExample() throws Exception {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andUsernameLike("%小%");
        List<Student> list = studentMapper.selectByExample(studentExample);
        System.out.println(list);
    }
}
