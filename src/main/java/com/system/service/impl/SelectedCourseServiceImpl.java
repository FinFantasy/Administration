package com.system.service.impl;

import com.system.mapper.SelectedCourseMapperCustom;
import com.system.mapper.SelectedcourseMapper;
import com.system.mapper.StudentMapper;
import com.system.po.*;
import com.system.service.SelectedCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SelectedCourseMapperCustom selectedCourseMapperCustom;

    @Override
    public List<SelectedCourseCustom> findByCourseID(Integer id) throws Exception {

        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);
        List<SelectedCourseCustom> secList = new ArrayList<>();
        for (Selectedcourse s : list) {
            SelectedCourseCustom sec = new SelectedCourseCustom();
            BeanUtils.copyProperties(s, sec);
            //判断是否完成类该课程
            if (sec.getMark() != null) {
                sec.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(sec.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sec.setStudentCustom(studentCustom);
            secList.add(sec);
        }
        return secList;
    }

    @Override
    public List<SelectedCourseCustom> findByCourseIDPaging(PagingVO pagingVO, Integer id) throws Exception {

        List<Selectedcourse> list = selectedCourseMapperCustom.findByPaging(pagingVO, id);
        List<SelectedCourseCustom> secList = new ArrayList<>();

        for (Selectedcourse s : list) {
            SelectedCourseCustom sec = new SelectedCourseCustom();
            BeanUtils.copyProperties(s, sec);
            //判断是否完成类该课程
            if (sec.getMark() != null) {
                sec.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(sec.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sec.setStudentCustom(studentCustom);
            secList.add(sec);
        }
        return secList;
    }

    //获取该课程学生数
    @Override
    public Integer countByCourseID(Integer id) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);

        return selectedcourseMapper.countByExample(example);
    }

    //查询指定学生成绩

    @Override
    public SelectedCourseCustom findOne(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);

        if (list.size() > 0) {
            SelectedCourseCustom sc = new SelectedCourseCustom();
            BeanUtils.copyProperties(list.get(0), sc);

            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sc.setStudentCustom(studentCustom);

            return sc;
        }
        return null;
    }

    @Override
    public void updateOne(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.updateByExample(selectedCourseCustom, example);
    }

    @Override
    public void save(SelectedCourseCustom selectedCourseCustom) throws Exception {
        selectedcourseMapper.insert(selectedCourseCustom);
    }

    @Override
    public List<SelectedCourseCustom> findByStudentID(Integer id) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andStudentidEqualTo(id);

        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);

        List<SelectedCourseCustom> secList = new ArrayList<SelectedCourseCustom>();

        for (Selectedcourse s : list) {
            SelectedCourseCustom sec = new SelectedCourseCustom();
            BeanUtils.copyProperties(s, sec);
            //判断是否完成类该课程
            if (sec.getMark() != null) {
                sec.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(sec.getStudentid());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sec.setStudentCustom(studentCustom);
            secList.add(sec);
        }
        return secList;
    }

    @Override
    public void remove(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseidEqualTo(selectedCourseCustom.getCourseid());
        criteria.andStudentidEqualTo(selectedCourseCustom.getStudentid());

        selectedcourseMapper.deleteByExample(example);
    }
}
