package com.cnasurety.extagencyint.batches.ivans.purge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("batch.purge")
@PropertySources(value = {@PropertySource(value = "classpath:application.properties")})
public class ApplicationConfig { 
	String days;

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	
	
	

}
