package com.imtcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/*
 	NOTE:
 	We don't have to annotate this class with @EnableSwagger2 as we are are not adding spring-fox dependency in pom.xml
 	Adding springdoc-openapi-ui dependency in pom.xml automatically enable swagger without any annotation
 */

@SpringBootApplication
public class InsuranceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceManagementSystemApplication.class, args);
	}

	
	//	we are configuring "LocalValidatorFactoryBean" as Spring bean object here. It uses "ReloadableResourceBundleMessageSource"
	//  class to read the messages.properties file and resolve the validation messages.
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		
		LocalValidatorFactoryBean localValidatorFactoryBean= new LocalValidatorFactoryBean();
		
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		
		return localValidatorFactoryBean;
	}
}
