package net.slipp.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("net.slipp.dao")
public class DaoConfig {
	@Bean(name="dataSource")
	public DataSource dataSource() throws PropertyVetoException{
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/slipp_user");
		ds.setUser("root");
		ds.setPassword("");
		return ds;
	}
}
