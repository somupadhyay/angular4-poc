/**
 * 
 */
package org.batch.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author upadhs5
 *
 */
@Configuration
public class DBConfiguration {

	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").password("root").username("root").url("jdbc:mysql://localhost:3306/test2").build();
	}

	@Bean(name = "sourceDataSource")
	public DataSource sourceDataSource() {
		return DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").password("root").username("root").url("jdbc:mysql://localhost:3306/test").build();
	}
}
