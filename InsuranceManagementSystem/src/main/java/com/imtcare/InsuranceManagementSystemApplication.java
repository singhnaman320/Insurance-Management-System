package com.imtcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
