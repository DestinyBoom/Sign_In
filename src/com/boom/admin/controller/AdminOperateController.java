package com.boom.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.admin.service.AdminOperateService;
import com.boom.pojo.DbOperate;
import com.boom.utils.Result;

@Controller
@RequestMapping("/AdminOperate")
public class AdminOperateController {
	
	@Autowired
	private AdminOperateService adminOperateService;
	
	//查询所有班级信息带页数
	@ResponseBody
	@RequestMapping(value = "/findAll.action")
	public Result findAll() {
		Result result = adminOperateService.findAll();
		return result;
	}
		
	//添加班级信息
	@ResponseBody
	@RequestMapping(value = "/add.action")
	public Result addOperate(DbOperate dbOperate) {
		
		System.out.println(dbOperate);
		Result result = adminOperateService.addOperate(dbOperate);
		return result;
	}
	
	//修改班级信息
	@RequestMapping("/update.action")
    @ResponseBody
    public Result updateOperate(DbOperate dbOperate) {
        Result result = adminOperateService.updateOperate(dbOperate);
        return result;
    }
	
	//删除班级
	@RequestMapping("/delete.action")
    @ResponseBody
    public Result deleteOperate(HttpServletRequest request) {
		String[] ids=request.getParameterValues("ids");
		System.out.println(ids);
		Result result = null;
		if(ids.length!=0){
			result = adminOperateService.deleteOperate(ids);
	    }       
        return result;
    }
}
