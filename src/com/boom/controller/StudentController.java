package com.boom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.pojo.DbStudent;
import com.boom.service.StudentService;
import com.boom.utils.Result;

/**
 * 学生访问接口
 * 
 * @author Administrator
 */
@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// 登录
	@ResponseBody
	@RequestMapping(value = "/login.action", method = {RequestMethod.POST })
	public Result login(DbStudent dbStudent) {
		System.out.println(dbStudent);
		return studentService.login(dbStudent);
	}

	// 注册
	@ResponseBody
	@RequestMapping(value = "/regist.action", method = {RequestMethod.POST })
	public Result regist(DbStudent dbStudent) {
		System.out.println(dbStudent);
		return studentService.regist(dbStudent);
	}
	
	//保存
	@ResponseBody
	@RequestMapping(value = "/save.action", method = {RequestMethod.POST })
	public Result save(DbStudent dbStudent) {
		System.out.println(dbStudent);
		return studentService.save(dbStudent);
	}
	
	//修改密码
	@ResponseBody
	@RequestMapping(value = "/updatepass.action")
	public Result updatepass(DbStudent dbStudent) {
		System.out.println(dbStudent);
		return studentService.updatepass(dbStudent);
	}
}
