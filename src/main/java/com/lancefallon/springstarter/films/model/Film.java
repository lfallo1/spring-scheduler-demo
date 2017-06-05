package com.lancefallon.springstarter.films.model;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable {

	private static final long serialVersionUID = -821977590418496382L;

	private Integer id;
	private String title;
	private String genre;
	private Date release;

	public Film() {
	}

	public Film(Integer id, String title, String genre, Date release) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.release = release;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", genre=" + genre + ", release=" + release + "]";
	}

}
