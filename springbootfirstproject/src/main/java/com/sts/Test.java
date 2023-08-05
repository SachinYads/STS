package com.sts;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Test {
	
	@RequestMapping("/test")
	@ResponseBody
	public String name() {
		return "home";
	}

}
