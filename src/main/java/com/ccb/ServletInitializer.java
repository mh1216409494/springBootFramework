package com.ccb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		ApplicationListeners applicationListeners=new ApplicationListeners();
//		application.listeners(applicationListeners);
		return application.sources(Application.class);
	}


}
