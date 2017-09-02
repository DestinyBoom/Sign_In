package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminAcademyService;
import com.boom.interceptor.Role;
import com.boom.pojo.DbAcademy;
import com.boom.utils.Result;

/**
 * 供访问的接口
 * @author Administrator
 *
 */
@CrossOrigin(methods = RequestMethod.POST)
@Controller
@RequestMapping("/AdminAcademy")
public class AdminAcademyController {
	
	@Autowired
	private AdminAcademyService adminAcademyService;
	
	//查询所有学院接口
	@ResponseBody
	@RequestMapping("/findAll.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result findAll() {
		Result result = adminAcademyService.findAll();
		return result;
	}
	
	//添加学院信息
	@ResponseBody
	@RequestMapping("/add.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result addStudent(DbAcademy dbAcademy) {
		
		Result result = adminAcademyService.addAcademy(dbAcademy);
		return result;
	}
	
	//修改学院信息
	@RequestMapping("/update.action")
    @ResponseBody
    @Role(role=Role.ROLE_ADMIN)
    public Result updateBusiness(DbAcademy dbAcademy) {
        Result result = adminAcademyService.updateAcademy(dbAcademy);
        return result;
    }
	
	//删除学院
	@RequestMapping("/delete.action")
    @ResponseBody
    @Role(role=Role.ROLE_ADMIN)
    public Result deleteStudent(HttpServletRequest request) {
		String[] ids=request.getParameterValues("ids");
		System.out.println(ids);
		Result result = null;
		if(ids.length!=0){
			result = adminAcademyService.deleteAcademy(ids);
	    }       
        return result;
    }
}
