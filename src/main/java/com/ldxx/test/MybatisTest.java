package com.ldxx.test;


import com.ldxx.bean.User;
import com.ldxx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        //int i= service.addUser( user );
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = localDateTime.format(dateTimeFormatter);
		System.out.println(date);
	}

	public static void main(String[] args) {
		Thread thread = new Thread();

	}
}
