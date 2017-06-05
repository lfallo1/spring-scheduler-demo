package com.lancefallon.springstarter.films.sql;

import org.springframework.jdbc.core.RowMapper;

import com.lancefallon.springstarter.films.model.Film;

public interface FilmSql {
	
	//row cols
	String FILM_COL_RELEASE = "release";
	String FILM_COL_GENRE = "genre";
	String FILM_COL_TITLE = "title";
	String FILM_COL_ID = "id";
	
	//sql
	String FILM_FIND_BY_ID_SQL = String.format("select * from public.film where %s = ?", FILM_COL_ID);
	String FILM_ADD_SQL = String.format("insert into public.film (%s, %s, %s) values(?,?,?)", FILM_COL_TITLE, FILM_COL_GENRE, FILM_COL_RELEASE);
	String FILM_FIND_ALL = "select * from public.film";
	
	//mappers
	RowMapper<Film> FILM_ROW_MAPPER = (rs, rowNum) -> {
		Film film = new Film();
		film.setId(rs.getInt(FILM_COL_ID));
		film.setTitle(rs.getString(FILM_COL_TITLE));
		film.setGenre(rs.getString(FILM_COL_GENRE));
		film.setRelease(rs.getDate(FILM_COL_RELEASE));
		return film;
	};
}
