package com.ldxx.test;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldxx.bean.User;
import com.ldxx.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisTest {
	
	@Autowired
	private UserService service;
	
	private User user=new User();

	@Test
	public void mybatisMethod(){
		user.setUserId("11");
		user.setuName("lisi");
        int i= service.addUser( user );
        System.out.println(i);
	}

}
