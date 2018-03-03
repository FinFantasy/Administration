package com.system.service.impl;

import com.system.po.Userlogin;
import com.system.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class UserloginServiceImplTest {

    @Autowired
    private UserLoginService userLoginService;

    @Test
    public void findByName() throws Exception {
        Userlogin userlogin = userLoginService.findByName("admin");
        System.out.println(userlogin);
    }

    @Test
    public void save() throws Exception {
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername("100100");
        userlogin.setPassword("123");
        userlogin.setRole(2);
        userLoginService.save(userlogin);
    }

    @Test
    public void removeByName() throws Exception {
        userLoginService.removeByName("100100");
    }

}
