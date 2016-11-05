package com.lancefallon.usermgmt.users.sql;

import org.springframework.jdbc.core.RowMapper;

import com.lancefallon.usermgmt.users.model.User;

public interface UserSql {
	
	//row cols
	String USER_COL_DOB = "dob";
	String USER_COL_EMAIL = "email";
	String USER_COL_USERNAME = "username";
	String USER_COL_ID = "id";
	
	//sql
	String USER_FIND_BY_ID_SQL = String.format("select * from public.user where %s = ?", USER_COL_ID);
	String USER_ADD_SQL = String.format("inser into public.user (%s, %s, %s) values(?,?,?)", USER_COL_USERNAME, USER_COL_EMAIL, USER_COL_DOB);
	String USER_FIND_ALL = "select * from public.user";
	
	//mappers
	RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
		User user = new User();
		user.setId(rs.getInt(USER_COL_ID));
		user.setUsername(rs.getString(USER_COL_USERNAME));
		user.setEmail(rs.getString(USER_COL_EMAIL));
		user.setDob(rs.getDate(USER_COL_DOB));
		return user;
	};
}
