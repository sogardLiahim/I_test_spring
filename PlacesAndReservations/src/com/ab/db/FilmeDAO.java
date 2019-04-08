package com.ab.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ab.model.Film;

@Repository
public class FilmeDAO {

	private JdbcTemplate jdbcTemplate;

	private DataSource ds;
	
	@Qualifier("dataSource")
	@Autowired
	public void setDs(DataSource ds) {
		this.jdbcTemplate  = new JdbcTemplate(ds);
	}
	
	//ID, NUME_FILM, DESCRIERE, SALA_ID, PRET, GEN_FILM, DATA_SI_ORA_FILM
	public class FilmMapper implements RowMapper<Film> {
		   public Film mapRow(ResultSet rs, int rowNum) throws SQLException {  
			   long id = rs.getLong("ID");
			   String numeFilm = rs.getString("NUME_FILM");	
			   String descriere = rs.getString("DESCRIERE");
			   String salaId = rs.getString("SALA_ID");
			   String pret = rs.getString("PRET");
			   String genFilm = rs.getString("GEN_FILM");
			   Timestamp dataSiOra = rs.getTimestamp("DATA_SI_ORA_FILM");
			   Film film =  new Film(id, numeFilm,descriere, salaId, pret, genFilm, dataSiOra);
		 
			   return film;
		   }
		}
	
	
	public List<Film> getMovies () 
	{    
		String queryString = "SELECT * FROM CINEMA.FILME";
		List<Film> filme = jdbcTemplate.query(queryString,new FilmMapper());
		
		return filme;
	}
	
	public List<Film> getMovies(Timestamp date) 
	{
	System.out.println(date);
		String queryString = "SELECT * FROM CINEMA.FILME"
				+ "WHERE DATA_SI_ORA_FILM BETWEEN ('?') "
				+ "AND DATE_ADD('?',INTERVAL 3 DAY)";
		List<Film> filme = jdbcTemplate.query(queryString, new Object[] {date, date},new FilmMapper());
		
		for (Film film : filme) {
			System.out.println(film.getNumeFilm());
		}
		return filme;
	}
	
	
	public void insertMovie(Film a)
	{
		String querryString = 
				"INSERT INTO cinema.filme(NUME_FILM,DESCRIERE,SALA_ID, "
				+ "PRET,GEN_FILM,DATA_SI_ORA_FILM) "
				+ "VALUES(?,?,?,?,?,?)";
	
		jdbcTemplate.update(querryString,new Object[] {a.getNumeFilm(), a.getDescriere(), a.getIdSala(),
													a.getPret(),a.getGenFilm(), a.getDataSiOra()});
	}
	

}
