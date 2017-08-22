/**
 * 
 */
package org.batch.tasklet;

import java.util.List;

import org.batch.dao.LegacyPersonDao;
import org.batch.dao.NewPersonDao;
import org.batch.domain.Persons;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author upadhs5
 *
 */
@Component
public class JdbcItemReader implements ItemReader<Persons> {

	@Autowired
	private LegacyPersonDao lPersonDao;

	@Autowired
	private NewPersonDao nPersonDao;

	@Override
	public Persons read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		List<Integer> ids = nPersonDao.getIds();
		Persons persons = new Persons();
		persons.setPersons(this.lPersonDao.getPersonNotIn(ids));
		return persons;
	}

}
