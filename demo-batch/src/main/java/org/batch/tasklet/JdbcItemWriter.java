/**
 * 
 */
package org.batch.tasklet;

import java.util.List;

import javax.sql.DataSource;

import org.batch.domain.Person;
import org.batch.domain.Persons;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author upadhs5
 *
 */
@Component
public class JdbcItemWriter implements ItemWriter<Persons> {

	@Autowired
	@Qualifier("targetDataSource")
	private DataSource dataSource;

	@Override
	public void write(List<? extends Persons> persons) throws Exception {
		JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		writer.setSql("INSERT INTO people (personid,first_name, last_name) VALUES (:personid, :firstName, :lastName)");
		writer.setDataSource(dataSource);
		persons.forEach(p -> {
			try {
				writer.write(p.getPersons());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
