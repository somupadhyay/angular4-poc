/**
 * 
 */
package org.batch.config;

import javax.sql.DataSource;

import org.batch.domain.Persons;
import org.batch.tasklet.JdbcItemReader;
import org.batch.tasklet.JdbcItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author upadhs5
 *
 */
@Configuration
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("targetDataSource")
	private DataSource dataSource;

	@Autowired
	private JdbcItemReader reader;

	@Autowired
	private JdbcItemWriter writer;

	@Bean
	public Step dataMigratorStep() {
		return stepBuilderFactory.get("migrateDB").<Persons, Persons>chunk(10).reader(reader).writer(writer).build();
	}

	@Bean
	public Job migrateDataJob(Step migrateDB) throws Exception {
		return jobBuilderFactory.get("migrateDataJob").incrementer(new RunIdIncrementer()).start(migrateDB).build();
	}

}
