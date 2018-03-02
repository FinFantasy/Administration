package com.system.service.impl;

import com.system.mapper.UserloginMapper;
import com.system.mapper.UserloginMapperCustom;
import com.system.po.Userlogin;
import com.system.po.UserloginExample;
import com.system.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserloginMapper userloginMapper;

    @Autowired
    private UserloginMapperCustom userloginMapperCustom;

    @Override
    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();

        criteria.andUsernameEqualTo(name);

        List<Userlogin> list = userloginMapper.selectByExample(userloginExample);

        return list.get(0);
    }

    @Override
    public void save(Userlogin userlogin) throws Exception {
        userloginMapper.insert(userlogin);
    }

    @Override
    public void removeByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();

        criteria.andUsernameEqualTo(name);

        userloginMapper.deleteByExample(userloginExample);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();

        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }

    @Override
    public String findPicPathByName(String userName) {
        return userloginMapperCustom.findPicPathByName(userName);
    }

    @Override
    public void savePicPathByName(String userName, String picPathName) {
        userloginMapperCustom.savePicPathByName(userName, picPathName);
    }
}
