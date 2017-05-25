package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminStudentService;
import com.boom.pojo.DbStudent;
import com.boom.pojo.DbStudentCustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

/**
 * 管理员管理学生接口
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/AdminStudent")
public class AdminStudentController {
	
	@Autowired
	private AdminStudentService adminstudentService;

	//查询所有学生信息带页数
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	public PageResult findAll(Integer page) {		
		PageResult result = adminstudentService.findAll(page);
		return result;
	}
		
	//添加学生信息
	@ResponseBody
	@RequestMapping(value = "/add.action")
	public Result addStudent(DbStudent dbStudent) {
		
		System.out.println(dbStudent);
		Result result = adminstudentService.addStudent(dbStudent);
		return result;
	}
	
	//修改学生信息
	@RequestMapping("/update.action")
    @ResponseBody
    public Result updateStudent(DbStudent dbStudent) {
        Result result = adminstudentService.updateStudent(dbStudent);
        return result;
    }
	
	//删除学生
	@RequestMapping("/delete.action")
    @ResponseBody
    public Result deleteStudent(HttpServletRequest request) {
		String[] ids=request.getParameterValues("ids");
		System.out.println(ids);
		Result result = null;
		if(ids.length!=0){
			result = adminstudentService.deleteStudent(ids);
	    }       
        return result;
    }
	
	//高级搜索
	@ResponseBody
	@RequestMapping(value = "/select.action")
	public PageResult selectStudent(DbStudentCustomer dbStudentCustomer, Integer page) {
		PageResult result = adminstudentService.selectStudent(dbStudentCustomer,page);
		return result;
	}
}
