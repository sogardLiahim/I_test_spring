package com.ab.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DAOImpl {

	
	private JdbcTemplate jdbcTemplate;

	private DataSource ds;
	
	@Qualifier("dataSource")
	@Autowired
	public void setDs(DataSource ds) {
		System.out.println("Spring-ul injecteaza datasource-ul");
		this.jdbcTemplate  = new JdbcTemplate(ds);
		nameProdus();
	}

	
	
   public String nameProdus() 
  {
	String nume =  jdbcTemplate.queryForObject("SELECT NUME FROM online_buy.client where online_buy.client.telefon like ? ", new Object[] {"%29015%"},String.class);   
	System.out.println(nume);
	return null;
  }	
	
	
	
	
	
	
	
	public String test() throws SQLException {
		String query = "SELECT nume FROM online_buy.client c where c.id=1";
		String s = this.jdbcTemplate.queryForObject(query,  String.class);
		
		return s;
	}
	


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
