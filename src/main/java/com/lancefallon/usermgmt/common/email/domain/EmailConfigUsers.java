package com.lancefallon.usermgmt.common.email.domain;

import java.util.List;

import com.lancefallon.usermgmt.users.model.User;

/**
 * Email config for user related emails
 * @author lancefallon
 *
 */
public class EmailConfigUsers extends EmailConfig {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
