package com.ab.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ab.model.Persoane;

@Component
public class PersoaneDAO {

	private JdbcTemplate jdbcTemplate;

	private DataSource ds;

	@Qualifier("dataSource")
	@Autowired
	public void setDs(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public class PersoaneMap implements RowMapper<Persoane> {
	   public Persoane mapRow(ResultSet rs, int rowNum) throws SQLException { 
		 String nume = rs.getString("NUME_PERSOANA"); Persoane person = new Persoane(nume);
		 return person;
      }
	}

	public List<Persoane> getAllPersons() {
		List<Persoane> a = jdbcTemplate.query("SELECT * FROM CINEMA.PERSOANA", new PersoaneMap());
		return a;
	}

}
