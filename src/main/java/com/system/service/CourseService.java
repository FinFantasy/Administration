package com.system.service;

import com.system.po.CourseCustom;
import com.system.po.PagingVO;

import java.util.List;

public interface CourseService {

    //根据id更新课程信息
    void updateById(Integer id, CourseCustom courseCustom) throws Exception;

    //根据id删除课程信息
    Boolean removeById(Integer id) throws Exception;

    //获取分页查询课程信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

    //插入课程信息
    Boolean save(CourseCustom courseCustom) throws Exception;

    //获取课程总数
    int getCountCourse() throws Exception;

    //根据id查询
    CourseCustom findById(Integer id) throws Exception;

    //根据名字查询
    List<CourseCustom> findByName(String name) throws Exception;

    //根据教师id查找课程
    List<CourseCustom> findByTeacherID(Integer id) throws Exception;
}
