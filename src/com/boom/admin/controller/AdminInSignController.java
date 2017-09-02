package com.boom.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminInSignService;
import com.boom.interceptor.Role;
import com.boom.pojo.DbDay;
import com.boom.pojo.DbDayCustomer;
import com.boom.pojo.DbInSignCustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageInfo;

/**
 * 管理员管理签到接口
 * 
 * @author Administrator
 *
 */
@CrossOrigin(methods = RequestMethod.POST)
@Controller
@RequestMapping("/AdminInSign")
public class AdminInSignController {
	
	@Autowired
	private AdminInSignService adminInSignService;
	
	//开启签到
	@ResponseBody
	@RequestMapping(value = "/OpenSign.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result OpenSign() {
		Result result = adminInSignService.updateOpenSign();
		return result;
	}
	
	//关闭签到
	@ResponseBody
	@RequestMapping(value = "/CloseSign.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result CloseSign() {
		Result result = adminInSignService.updateCloseSign();
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findTByMonthAndDay.action")
	@Role(role=Role.ROLE_ADMIN)
	public PageResult findTByMonthAndDay(DbInSignCustomer dbInSignCustomer,Integer page) {
		PageResult result = adminInSignService.findTByMonthAndDay(dbInSignCustomer, page);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	@Role(role=Role.ROLE_ADMIN)
	public PageResult findAll(Integer page) {
		PageResult result = adminInSignService.findAll(page);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result updateStatus(DbDay dbDay) {
		Result result = adminInSignService.updateStatus(dbDay);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findInsignToady.action")
	@Role(role=Role.ROLE_ADMIN)
	public PageInfo<DbDayCustomer> findInsignToady(Integer page) {
		PageInfo<DbDayCustomer> result = adminInSignService.findInsignToady(page);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/retroactive.action")
	@Role(role=Role.ROLE_ADMIN)
	public Result retroactive(String month, String day, Integer tid, String time) {
		Result result = adminInSignService.updateRetroactive(month, day ,tid, time);
		return result;
	}
}
