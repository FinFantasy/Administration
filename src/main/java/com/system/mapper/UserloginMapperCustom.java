package com.system.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserloginMapperCustom {

    String findPicPathByName(String userName);

    void savePicPathByName(@Param("userName") String userName, @Param("picPath") String picPath);
}
