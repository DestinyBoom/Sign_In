package com.boom.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminWaysignservice;
import com.boom.pojo.DbWaysign;
import com.boom.utils.Result;

@Controller
@RequestMapping("/AdminWaysign")
public class AdminWaysignController {
	
	@Autowired
	private AdminWaysignservice adminWaysignservice;
	
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	public Result findAll() {
		Result result = adminWaysignservice.findAll();
		return result;
	}
	
	@RequestMapping("/update.action")
    @ResponseBody
    public Result updateWaysign(DbWaysign dbWaysign) {
        Result result = adminWaysignservice.updateWaysign(dbWaysign);
        return result;
    }
}
