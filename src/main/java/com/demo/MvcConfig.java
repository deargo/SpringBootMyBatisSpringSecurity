package com.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class MvcConfig extends WebMvcConfigurerAdapter  {

	//直接页面跳转，不经过Controller，这样在没有任何处理业务的时候,快捷的页面转向定义会节省好多代码
	@Override
	 public void addViewControllers(ViewControllerRegistry registry)
	 {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		//registry.addViewController("/hello").setViewName("hello");
		//registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/denied").setViewName("denied");
		//registry.addViewController("/admin").setViewName("admin");
	 }
}
