/**
 * 
 */
package org.batch.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.batch.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author upadhs5
 *
 */
@Repository
public class LegacyPersonDao {

	@Autowired
	public LegacyPersonDao(@Qualifier("sourceDataSource") DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private DataSource dataSource;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Person> getPersonNotIn(List<Long> ids) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", ids);
		List<Person> persons = new ArrayList<Person>();
		return namedParameterJdbcTemplate.query("select idpeople, first_name, last_name from people where idpeople not in (:ids)", parameters,
				(ResultSet rs) -> {
					while (rs.next()) {
						Person person = new Person();
						person.setPersonid(rs.getInt("idpeople"));
						person.setFirstName(rs.getString("first_name"));
						person.setLastName(rs.getString("last_name"));

						persons.add(person);
					}
					return persons;
				});
	}
}
