package com.system.mapper;

import com.system.po.PagingVO;
import com.system.po.Selectedcourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedCourseMapperCustom {

    List<Selectedcourse> findByPaging(@Param("pagingVO")PagingVO pagingVO,
                                      @Param("id") Integer id) throws Exception;
}
