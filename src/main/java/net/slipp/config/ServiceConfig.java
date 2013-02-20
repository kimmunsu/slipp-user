package net.slipp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("net.slipp.service")
public class ServiceConfig {
	
	private DaoConfig daoConfig;
	
	@Autowired
	public void setDaoConfig(DaoConfig daoConfig){
		this.daoConfig = daoConfig;
	}
}
