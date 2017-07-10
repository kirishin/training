package com.example.umatsu.trainingCRUD.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.slf4j.Slf4j;

@WebFilter(filterName="logContextPathFilter", urlPatterns="/notAccessPattern")
@Slf4j
public class LogContextPathFilter implements javax.servlet.Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();	
		log.info("アクセスURLのコンテキストパス：{}", context.getContextPath());
		// これなんかもっといい方法ないかな？　ブラウザでアクセスするURLはこれです。ってのをログに出したい
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
