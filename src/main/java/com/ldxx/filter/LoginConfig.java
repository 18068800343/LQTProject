package com.ldxx.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginConfig extends WebMvcConfigurerAdapter{
	

	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(loginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/**/js/**")
				.excludePathPatterns("/**/img/**")
				.excludePathPatterns("/**/resources/**")
				.excludePathPatterns("/**/resources/**")
				.excludePathPatterns("/**/view/css/**")
				.excludePathPatterns("/**/view/easyUI/**")
				.excludePathPatterns("/**/view/font2/**")
				.excludePathPatterns("/**/view/font3/**")
				.excludePathPatterns("/**/view/fonts/**")
				.excludePathPatterns("/**/view/geoJson/**")
				.excludePathPatterns("/**/view/font-awesome.4.5.0/**")
				.excludePathPatterns("/**/view/images/**")
				.excludePathPatterns("/**/view/img/**")
				.excludePathPatterns("/**/view/js/**")
				.excludePathPatterns("/**/view/kindeditor/**")
				.excludePathPatterns("/**/view/resources/**")
				.excludePathPatterns("/**/view/select/**")
				.excludePathPatterns("/**/view/style/**")
				.excludePathPatterns("/**/view/toastr/**")
				.excludePathPatterns("/**/view/ueditor/**")
				.excludePathPatterns("/**/view/utf8-php/**")
				.excludePathPatterns("/**/view/**.ico")
		.excludePathPatterns("/**/view/WEB/login.html");
	}
	}
