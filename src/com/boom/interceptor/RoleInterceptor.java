package com.boom.interceptor;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.boom.utils.JsonUtil;

public class RoleInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handle) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handle;
		java.lang.reflect.Method method = handlerMethod.getMethod();
		Role role = method.getAnnotation(Role.class);
		if (role != null) {
			int roleCode = role.role();
			if (roleCode == 1) {
				String tokenint = request.getParameter("token");
				Integer token = (Integer) request.getSession().getAttribute(
						"admin");
				//System.out.println(tokenint);
				//System.out.println(token);
				if (tokenint == null || token == null) {
					send(response, 405);
					request.getSession().invalidate();
					return false;
				}
				if (String.valueOf(token).equals(tokenint)) {
					return true;
				} else {
					send(response, 405);
					request.getSession().invalidate();
					return false;
				}
			}
		}
		return true;
	}

	public void send(HttpServletResponse response, int status) {
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setContentType("application/json;charset=UTF-8");
		JSONObject jsonObjec = JsonUtil.createJson(status);
		jsonObjec.element("msg", "未登录，不能进行操作");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		try {
			response.getWriter().print(jsonObjec.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
