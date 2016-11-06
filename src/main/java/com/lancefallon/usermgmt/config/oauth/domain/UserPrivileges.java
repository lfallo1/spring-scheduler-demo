/**
 * 
 */
package com.lancefallon.usermgmt.config.oauth.domain;

import java.io.Serializable;
import java.util.List;

public class UserPrivileges implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;

	private int userID;

	private String defaultDB;

	private String presentDB;

	private List<String> dbList;

	private boolean isAuthenticated;

	public String getDefaultDB() {
		return defaultDB;
	}

	public void setDefaultDB(String defaultDB) {
		this.defaultDB = defaultDB;
	}

	public List<String> getDbList() {
		return dbList;
	}

	public void setDbList(List<String> dbList) {
		this.dbList = dbList;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public String getPresentDB() {
		return presentDB;
	}

	public void setPresentDB(String presentDB) {
		this.presentDB = presentDB;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
