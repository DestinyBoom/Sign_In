package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminClassService;
import com.boom.pojo.DbClass;
import com.boom.utils.Result;



/**
 * 管理员管理班级接口
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/AdminClass")
public class AdminClassController {
	
	@Autowired
	private AdminClassService adminClassService;
	
	//查询所有班级信息带页数
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	public Result findAll() {
		Result result = adminClassService.findAll();
		return result;
	}
		
	//添加班级信息
	@ResponseBody
	@RequestMapping(value = "/add.action")
	public Result addStudent(DbClass dbClass) {
		
		System.out.println(dbClass);
		Result result = adminClassService.addClass(dbClass);
		return result;
	}
	
	//修改班级信息
	@RequestMapping("/update.action")
    @ResponseBody
    public Result updateBusiness(DbClass dbClass) {
        Result result = adminClassService.updateClass(dbClass);
        return result;
    }
	
	//删除班级
	@RequestMapping("/delete.action")
    @ResponseBody
    public Result deleteStudent(HttpServletRequest request) {
		String[] ids=request.getParameterValues("ids");
		System.out.println(ids);
		Result result = null;
		if(ids.length!=0){
			result = adminClassService.deleteClass(ids);
	    }       
        return result;
    }
}
