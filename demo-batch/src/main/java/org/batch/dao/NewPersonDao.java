package org.batch.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.batch.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository

public class NewPersonDao {

	private static final Logger log = LoggerFactory.getLogger(NewPersonDao.class);
	
	@Autowired
	public NewPersonDao(@Qualifier("dataSource") DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private DataSource dataSource;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Integer> getIds() {

		List<Integer> ids = new ArrayList<>();
		namedParameterJdbcTemplate.query("select idpeople from people", (ResultSet rs) ->{
			while (rs.next()) {
				ids.add(rs.getInt("idpeople"));
			}
		});
		log.info("record size {}",ids.size());
		log.info("retrieved ids {}",ids);
		return ids;
	}
	
	public void insertRecords(List<Person> persons) throws Exception{
		log.info("record size {}",persons.size());
		/*JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		writer.setSql("INSERT INTO people (idpeople,first_name, last_name) VALUES (:personid, :firstName, :lastName)");
		writer.setDataSource(dataSource);
		writer.write(persons);*/
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(persons.toArray());
		namedParameterJdbcTemplate.batchUpdate("INSERT INTO people (idpeople,first_name, last_name) VALUES (:personid, :firstName, :lastName)", batch);
	}
	
	
}
