package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminTeacherService;
import com.boom.interceptor.Role;
import com.boom.pojo.DbTeacher;
import com.boom.pojo.DbTeachercustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

@CrossOrigin(methods = RequestMethod.POST)
@Controller
@RequestMapping("/AdminTeacher")
public class AdminTeacherController {
	
	@Autowired
	private AdminTeacherService adminTeacherService;

	//查询所有学生信息带页数
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	@Role(role=Role.ROLE_ADMIN)
	public PageResult findAll(Integer page) {		
		PageResult result = adminTeacherService.findAll(page);
		return result;
	}
		
	//添加学生信息
	@ResponseBody
	@RequestMapping(value = "/add.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result addTeacher(DbTeacher dbTeacher) {
		
		//System.out.println(dbTeacher);
		Result result = adminTeacherService.addTeacher(dbTeacher);
		return result;
	}
	
	//修改学生信息
	@RequestMapping("/update.action")
    @ResponseBody
    @Role(role=Role.ROLE_ADMIN)
    public Result updateTeacher(DbTeacher dbTeacher) {
        Result result = adminTeacherService.updateTeacher(dbTeacher);
        return result;
    }
	
	//删除学生
	@RequestMapping("/delete.action")
    @ResponseBody
    @Role(role=Role.ROLE_ADMIN)
    public Result deleteTeacher(HttpServletRequest request) {
		String[] ids=request.getParameterValues("ids");
		//System.out.println(ids);
		Result result = null;
		if(ids.length!=0){
			result = adminTeacherService.deleteTeacher(ids);
	    }       
        return result;
    }
	
	//高级搜索
	@ResponseBody
	@RequestMapping(value = "/select.action")
	@Role(role=Role.ROLE_ADMIN)
	public PageResult selectTeacher(DbTeachercustomer dbTeachercustomer, Integer page) {
		PageResult result = adminTeacherService.selectTeacher(dbTeachercustomer, page);
		return result;
	}
}
