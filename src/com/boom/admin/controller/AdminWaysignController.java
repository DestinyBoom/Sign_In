package com.boom.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminWaysignservice;
import com.boom.interceptor.Role;
import com.boom.pojo.DbWaysign;
import com.boom.utils.Result;

@CrossOrigin(methods = RequestMethod.POST)
@Controller
@RequestMapping("/AdminWaysign")
public class AdminWaysignController {
	
	@Autowired
	private AdminWaysignservice adminWaysignservice;
	
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result findAll() {
		Result result = adminWaysignservice.findAll();
		return result;
	}
	
	@RequestMapping("/update.action")
    @ResponseBody
    @Role(role=Role.ROLE_ADMIN)
    public Result updateWaysign(DbWaysign dbWaysign) {
        Result result = adminWaysignservice.updateWaysign(dbWaysign);
        return result;
    }
}
