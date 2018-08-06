package com.eric.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.boot.config.ConfigBean;

@SpringBootApplication
@RestController
public class MyFirstBoot {

	@Autowired
	private ConfigBean configBean;
	
	@RequestMapping("/")
	public String index() {
		return "Server["+configBean.getServer()+":"+configBean.getPort()+"] said: Hello world!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstBoot.class, args);
	}
}
