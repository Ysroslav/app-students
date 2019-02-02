package ru.bodrov.student.appstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.bodrov.student.appstudents")
@SpringBootApplication
public class AppStudentsApplication {

	public static void main(String[] args) {
		System.getProperty("java.classpath");
		SpringApplication.run(AppStudentsApplication.class, args);
	}

}

