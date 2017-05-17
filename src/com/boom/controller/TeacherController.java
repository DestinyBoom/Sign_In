package com.boom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.pojo.DbTeacher;
import com.boom.service.TeacherService;
import com.boom.utils.Result;

/**
 * 学生访问接口
 * 
 * @author Administrator
 */
@Controller
@RequestMapping("/Teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	// 登录
	@ResponseBody
	@RequestMapping(value = "/login.action")
	public Result login(DbTeacher dbTeacher) {
		System.out.println(dbTeacher);
		return teacherService.login(dbTeacher);
	}

	// 注册
	@ResponseBody
	@RequestMapping(value = "/regist.action")
	public Result regist(DbTeacher dbTeacher) {
		System.out.println(dbTeacher);
		return teacherService.regist(dbTeacher);
	}
	
	//保存
	@ResponseBody
	@RequestMapping(value = "/save.action")
	public Result save(DbTeacher dbTeacher) {
		System.out.println(dbTeacher);
		return teacherService.save(dbTeacher);
	}
	
	//修改密码
	@ResponseBody
	@RequestMapping(value = "/updatepass.action")
	public Result updatepass(DbTeacher dbTeacher) {
		System.out.println(dbTeacher);
		return teacherService.updatepass(dbTeacher);
	}
}
