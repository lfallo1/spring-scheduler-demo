package com.lancefallon.usermgmt.config.dbrouting.service;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.lancefallon.usermgmt.config.dbrouting.domain.DbContextHolder;

public class DbRoutingDataSourceUtil extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
