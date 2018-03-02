package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.TeacherCustom;

import java.util.List;

public interface TeacherMapperCustom {

    List<TeacherCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
