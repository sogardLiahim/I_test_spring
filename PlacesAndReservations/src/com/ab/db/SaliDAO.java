package com.ab.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


 // pentru ca spring-ul sa poata vedea clasa si sa 
			// poata sa o instantieze atunci cand folosesti @Autowired
			// in clasa  ApplicationController
@Component
public class SaliDAO
{	
	private JdbcTemplate jdbcTemplate;
	private DataSource ds;//

	@Qualifier("dataSource")
	@Autowired
	public void setDS(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		// DataSource ds = new DataSource() ds.setUsername = "mihai";
	}


	public List<String> getSaliNo (Integer id) 
	{    
		String queryString = "SELECT LOCURI_RAND FROM CINEMA.RANDURI WHERE ID_SALA = ?";
		List<String> result =null;
		try {
			result = jdbcTemplate.queryForList(queryString, new Object[] {id}, String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}	
		return result;
	}
	
	public List<Integer> getSaliId ()
	{
		String queryString = "SELECT ID FROM CINEMA.SALI";
		List <Integer> result = null;
		result = jdbcTemplate.queryForList(queryString, new Object[] {}, Integer.class);
		return result;
	
	}

	public Integer getSaliCount() 
	{
		String val = jdbcTemplate.queryForObject(" SELECT COUNT(NUME_SALA) FROM CINEMA.SALI",String.class);
		return Integer.valueOf(val);
		
	}


	
}
