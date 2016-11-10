package com.lancefallon.usermgmt.config.dbrouting.domain;

public class DbContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
		if(contextHolder.get() == null){
			contextHolder.set(DbType.DB_DEFAULT);
		}
		return contextHolder.get();
	}

	public static void clearDbType() {
		contextHolder.remove();
	}
}
