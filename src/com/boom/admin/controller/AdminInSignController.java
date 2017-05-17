package com.boom.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminInSignService;
import com.boom.utils.Result;

/**
 * 管理员管理签到接口
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/AdminInSign")
public class AdminInSignController {
	
	@Autowired
	private AdminInSignService adminInSignService;
	
	//开启签到
	@ResponseBody
	@RequestMapping(value = "/OpenSign.action")
	public Result OpenSign() {
		Result result = adminInSignService.updateOpenSign();
		return result;
	}
}
