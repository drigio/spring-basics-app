package com.example.jwtssecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
		application.addListeners(new ApplicationPidFileWriter("./bin/app.pid"));
		application.run(args);
	}

}
