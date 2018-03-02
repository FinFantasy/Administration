package com.system.service;

import com.system.po.Userlogin;

public interface UserLoginService {

    //根据名字查找用户
    Userlogin findByName(String name) throws Exception;

    //保存用户登录信息
    void save(Userlogin userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;

    //根据用户名更新
    void updateByName(String name, Userlogin userlogin);

    //根据查找头像路径,其实使用findByName也可以,但为了一项数据要查找整个对象,对数据库不友好
    String findPicPathByName(String userName);

    void savePicPathByName(String userName, String picPathName);
}
