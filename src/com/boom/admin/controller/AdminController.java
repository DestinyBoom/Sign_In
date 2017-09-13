package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminService;
import com.boom.interceptor.Role;
import com.boom.pojo.DbAdmin;
import com.boom.utils.Result;

@CrossOrigin(methods = RequestMethod.POST)
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/login.action")
	@ResponseBody
	public Result login(HttpServletRequest request,
			HttpServletResponse response, DbAdmin admin) {
		DbAdmin adminData = adminService.findAdmin(admin);
		if (adminData != null) {
			int token = (int) (Math.random() * 1000000);
			//System.out.println(token);
			request.getSession().setAttribute("admin", token);
			//System.out.println(request.getSession().getAttribute("admin"));
			return Result.ok(token);

		}
		return Result.build(500, "用户名或者密码错误");

	}

	@RequestMapping("/findAdmin.action")
	@ResponseBody
	@Role(role = Role.ROLE_ADMIN)
	public Result findAdmin(HttpServletRequest request,
			HttpServletResponse response, DbAdmin admin) {
		DbAdmin adminData = adminService.findAdminByUname(admin.getUname());
		if (adminData != null) {
			return Result.ok(adminData);
		}
		return Result.build(500, "用户不存在");
	}

	@RequestMapping("/updateAdminPass.action")
	@ResponseBody
	@Role(role = Role.ROLE_ADMIN)
	public Result updateAdminPass(HttpServletRequest request,
			HttpServletResponse response, DbAdmin admin) {
		int status = adminService.updateAdminPass(admin);
		if (status != 0) {
			request.getSession().invalidate();
			return Result.ok();
		}
		return Result.build(500, "修改失败");
	}

	@RequestMapping("/signOut.action")
	@ResponseBody
	@Role(role = Role.ROLE_ADMIN)
	public Result signOut(HttpServletRequest request,
			HttpServletResponse response) {
		DbAdmin admin = (DbAdmin) request.getSession().getAttribute("admin");
		if (admin != null) {
			request.getSession().invalidate();
			return Result.ok();
		} else {
			return Result.build(500, "未登录");
		}
	}

}
