package com.lancefallon.springstarter.films.repository;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.sql.FilmSql;

@Service
public class FilmRepository extends JdbcDaoSupport implements FilmSql {
	
	public FilmRepository(@Autowired @Qualifier("primary") DataSource dataSource) {
		setDataSource(dataSource);
	}

	public Integer addFilm(Film film) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try{
			getJdbcTemplate().update(connection -> {
				PreparedStatement ps = connection.prepareStatement(FILM_ADD_SQL,
						new String[]{FILM_COL_ID});
				ps.setString(1, film.getTitle());
				ps.setString(2, film.getGenre());
				ps.setDate(3, new java.sql.Date(film.getRelease().getTime()));
				return ps;
			}, keyHolder);
	
			return keyHolder.getKey().intValue();
		} catch(DataAccessException e){
			System.out.println("record not added: " + e.getMessage());
			return -1;
		}
	}

	public List<Film> findAll() {
		return getJdbcTemplate().query(FILM_FIND_ALL, FILM_ROW_MAPPER);
	}

	public Film findById(Integer id) {
		
		return getJdbcTemplate().queryForObject(FILM_FIND_BY_ID_SQL, new Object[]{ id }, FILM_ROW_MAPPER);
	}

}
