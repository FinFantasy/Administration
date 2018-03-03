package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.StudentMapperCustom;
import com.system.po.*;
import com.system.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapperCustom studentMapperCustom;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public void updateById(Integer id, StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception {
        return studentMapperCustom.findByPaging(pagingVO);
    }

    @Override
    public Boolean save(StudentCustom studentCustom) throws Exception {
        Student student = studentMapper.selectByPrimaryKey(studentCustom.getUserid());
        if (student == null) {
            studentMapper.insert(studentCustom);
            return true;
        }
        return false;
    }

    //返回学生总数
    @Override
    public int getCountStudent() throws Exception {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();

        criteria.andUseridIsNotNull();

        return studentMapper.countByExample(example);
    }

    @Override
    public StudentCustom findById(Integer id) throws Exception {

        Student student = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom = null;
        if (student != null) {
            studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);
        }

        return studentCustom;
    }

    //模糊查询
    @Override
    public List<StudentCustom> findByName(String name) throws Exception {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<Student> list = studentMapper.selectByExample(studentExample);

        List<StudentCustom> studentCustomList = null;

        if (list != null) {
            studentCustomList = new ArrayList<StudentCustom>();
            for (Student s : list) {
                StudentCustom studentCustom = new StudentCustom();
                BeanUtils.copyProperties(s, studentCustom);
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeid());

                studentCustomList.add(studentCustom);
            }
        }
        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentAndSelectCourseListById(String id) throws Exception {
        StudentCustom studentCustom = studentMapperCustom.findStudentAndSelectCourseListById(Integer.parseInt(id));
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        for (SelectedCourseCustom s : list) {
            if (s.getMark() != null) {
                s.setOver(true);
            }
        }
        return studentCustom;
    }
}
