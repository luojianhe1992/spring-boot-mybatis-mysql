package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootMybatisApplication.class,
				args);

		System.out.println("程序正在运行...");

		for (String bean : applicationContext.getBeanDefinitionNames()) {
			System.out.println("bean: " + bean);
		}
	}
}
