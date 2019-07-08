package com.cnasurety.extagencyint.batches.ivans.purge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("batch.purge")
@PropertySources(value = {@PropertySource(value = "classpath:application.properties")})
public class ApplicationConfig { 
	int days;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	
	
	

}
