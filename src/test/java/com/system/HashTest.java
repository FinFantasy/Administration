package com.system;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class HashTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    public void hashTest() {
        //System.out.println(passwordService.encryptPassword("123"));
        //String saltedPassword = "$shiro1$md5$2$Mzp8oj34WzAgug9kB/2JNg==$ojxy7d8+58aOaBMW2wsxCg==";
        byte[] bytes = Base64.decode("3AvVhmFLUs0KTA3Kprsdag==");
        for (byte b : bytes) {
            System.out.print(b);
        }
    }
}
