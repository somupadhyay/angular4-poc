/**
 * 
 */
package org.batch.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author upadhs5
 *
 */
@Configuration
public class DBConfiguration {

	@Bean(name = "targetDataSource")
	public DataSource targetDataSource() {
		return DataSourceBuilder.create().driverClassName("org.hsqldb.jdbcDriver").password("").username("sa").url("jdbc:hsqldb:file:apids;shutdown=true").build();
	}

	@Bean(name = "sourceDataSource")
	public DataSource sourceDataSource() {
		return DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver").password("root").username("root").url("jdbc:mysql://localhost:3306/test").build();
	}
}
