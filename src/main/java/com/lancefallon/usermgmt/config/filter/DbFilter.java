package com.lancefallon.usermgmt.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.lancefallon.usermgmt.config.db.domain.DbContextHolder;
import com.lancefallon.usermgmt.config.db.domain.DbType;

public class DbFilter implements Filter {
	private static final String RESPONSE_HEADER_EXPIRES = "Expires";

	private static final String NO_CACHE = "no-cache";

	private static final String RESPONSE_HEADER_PRAGMA = "Pragma";

	private static final String NO_CACHE_NO_STORE_MUST_REVALIDATE = "no-cache, no-store, must-revalidate";

	private static final String RESPONSE_HEADER_CACHE_CONTROL = "Cache-Control";

	/**
	 * Default constructor.
	 */
	public DbFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Filter all incoming requests <br/>
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("In App Filter");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setHeader(RESPONSE_HEADER_CACHE_CONTROL, NO_CACHE_NO_STORE_MUST_REVALIDATE);
		// HTTP 1.0. Proxies.
		httpResponse.setHeader(RESPONSE_HEADER_PRAGMA, NO_CACHE);
		httpResponse.setDateHeader(RESPONSE_HEADER_EXPIRES, 0);
		
		String key = request.getParameter("key");
		if (DbType.DB_BACKUP.equalsIgnoreCase(key)){
			DbContextHolder.setDbType(DbType.DB_BACKUP);
		} else{
			DbContextHolder.setDbType(DbType.DB_DEFAULT);
		}
		
		try{
			chain.doFilter(request, response);
		} finally{
			DbContextHolder.clearDbType();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}
}
