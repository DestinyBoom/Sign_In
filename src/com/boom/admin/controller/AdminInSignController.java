package com.boom.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminInSignService;
import com.boom.pojo.DbDay;
import com.boom.pojo.DbInSignCustomer;
import com.boom.utils.PageResult;
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
	
	//关闭签到
	@ResponseBody
	@RequestMapping(value = "/CloseSign.action")
	public Result CloseSign() {
		Result result = adminInSignService.updateCloseSign();
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findTByMonthAndDay.action")
	public PageResult findTByMonthAndDay(DbInSignCustomer dbInSignCustomer,Integer page) {
		PageResult result = adminInSignService.findTByMonthAndDay(dbInSignCustomer, page);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus.action")
	public Result updateStatus(DbDay dbDay) {
		Result result = adminInSignService.updateStatus(dbDay);
		return result;
	}
}
