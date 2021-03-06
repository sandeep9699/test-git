package com.paas.sms.product.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public FilterRegistrationBean<CustomFilter> filterRegistrationBean() {
		FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<CustomFilter>();
		CustomFilter customFilter = new CustomFilter();

		registrationBean.setFilter(customFilter);
		registrationBean.addUrlPatterns("/paasproduct/*","/paassuite/*","/paasimage/*");
		registrationBean.setOrder(2); // set precedence
		return registrationBean;
	}
}