package com.ntgclarity.smartcompound.spring.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
@EnableAutoConfiguration()  
@SpringBootApplication      
@Configuration   
/** 
 * update by karim 
 **/
@ImportResource(locations = 
		{"classpath:/spring/database/database.xml","classpath:/spring/database/spring-context.xml"})  
@ComponentScan("com.**") 
// search the com.company package for @Component classes
public class SmartCompoundApplication {    
 
	public static void main(String[] args) {
		SpringApplication.run(SmartCompoundApplication.class, args);
	}
}
