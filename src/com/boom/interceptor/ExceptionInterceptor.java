package com.boom.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.boom.admin.mapper.ErrLogMapper;

@Component
public class ExceptionInterceptor implements HandlerExceptionResolver{
	
	@Autowired
	ErrLogMapper errLogMapper;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object hander, Exception e) {
		//System.out.println("haha"+e);
		com.boom.pojo.Exception exception = new com.boom.pojo.Exception();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String date = sm.format(new Date());
		exception.setDate(date);
		
		StackTraceElement[] trace = e.getStackTrace();
		String message = "\tat " + e.getMessage() + "\r\n";
		for (StackTraceElement s : trace) {
			message += "\tat " + s + "\r\n";
		}
		exception.setText(message);
		errLogMapper.insertException(exception);
		return null;
	}
	
}
