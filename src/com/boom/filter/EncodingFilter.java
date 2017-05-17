package com.boom.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码处理过滤器
 * 
 * @author Administrator
 * 
 */
public class EncodingFilter implements Filter {
	private String charset = "UTF-8";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getMethod().equalsIgnoreCase("GET")) {
			if (!(req instanceof GetRequest)) {
				req = new GetRequest(req, charset);// 处理get请求编码
			}
		} else {
			req.setCharacterEncoding(charset);// 处理post请求编码
		}
		
        String origin = (String) request.getRemoteHost() + ":" + request.getRemotePort();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println(origin);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String charset = fConfig.getInitParameter("charset");
		if (charset != null && !charset.isEmpty()) {
			this.charset = charset;
		}
	}
}