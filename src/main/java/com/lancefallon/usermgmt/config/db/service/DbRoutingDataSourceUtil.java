package com.lancefallon.usermgmt.config.db.service;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.lancefallon.usermgmt.config.db.domain.DbContextHolder;

public class DbRoutingDataSourceUtil extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
