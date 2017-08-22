/**
 * 
 */
package org.batch.tasklet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.batch.dao.NewPersonDao;
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
	private NewPersonDao nPersonDao;

	@Override
	public void write(List<? extends Persons> persons) throws Exception {
		List<Person> prsns = new ArrayList<>();
		persons.forEach(p -> {
			prsns.addAll(p.getPersons());
		});
		nPersonDao.insertRecords(prsns);
	}

}
