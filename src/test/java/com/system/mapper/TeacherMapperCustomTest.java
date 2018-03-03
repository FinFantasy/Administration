package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.TeacherCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class TeacherMapperCustomTest {

    @Autowired
    private TeacherMapperCustom teacherMapperCustom;

    @Test
    public void findByPaging() throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(1);
        List<TeacherCustom> list = teacherMapperCustom.findByPaging(pagingVO);
        System.out.println(list);
    }
}