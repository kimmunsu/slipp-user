package net.slipp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("net.slipp.Controller")
public class ControllerConfig {

	private ServiceConfig serviceConfig;
	
	@Autowired
	public void setServiceConfig(ServiceConfig serviceConfig){
		this.serviceConfig = serviceConfig;
	}
	
	@Bean
	InternalResourceViewResolver irResolver(){
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
}
