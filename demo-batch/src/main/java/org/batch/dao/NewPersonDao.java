package org.batch.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NewPersonDao {

	
	@Autowired
	public NewPersonDao(@Qualifier("targetDataSource") DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private DataSource dataSource;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Long> getIds() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", '1');
		List<Long> ids = new ArrayList<>();
		return namedParameterJdbcTemplate.query("select idpeoplefrom people where 1 = :id", parameters,
				(ResultSet rs) -> {
					while (rs.next()) {
						long id = rs.getInt("idpeople");
						ids.add(id);
					}
					return ids;
				});
	}
}
