package by.tc.finalproject.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse httpres = (HttpServletResponse) servletResponse;
		httpres.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		httpres.setHeader("Pragma", "no-cache");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}

}
