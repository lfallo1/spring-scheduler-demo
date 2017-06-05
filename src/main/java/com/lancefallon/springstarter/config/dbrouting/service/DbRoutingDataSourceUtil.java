package com.lancefallon.springstarter.config.dbrouting.service;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.lancefallon.springstarter.config.dbrouting.domain.DbContextHolder;

public class DbRoutingDataSourceUtil extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
