package com.lancefallon.usermgmt.users.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.lancefallon.usermgmt.users.model.User;
import com.lancefallon.usermgmt.users.sql.UserSql;

@Service
public class UserRepository extends JdbcDaoSupport implements UserSql {
	
	public UserRepository(@Autowired @Qualifier("primary") DataSource dataSource) {
		setDataSource(dataSource);
	}

	public Integer addUser(User user) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(connection -> {
			PreparedStatement ps = connection.prepareStatement(USER_ADD_SQL,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			return ps;
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	public List<User> findAll() {
		return getJdbcTemplate().query(USER_FIND_ALL, USER_ROW_MAPPER);
	}

	public User findById(Integer id) {
		
		return getJdbcTemplate().queryForObject(USER_FIND_BY_ID_SQL, new Object[]{ id }, USER_ROW_MAPPER);
	}

}
