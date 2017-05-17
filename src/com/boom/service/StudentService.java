package com.boom.service;

import com.boom.pojo.DbStudent;
import com.boom.utils.Result;


/**
 * 学生业务接口
 * @author Administrator
 *
 */
public interface StudentService {
	
	//学生登录功能
	public Result login(DbStudent dbStudent);
	
	//学生注册功能
	public Result regist(DbStudent dbStudent);
	
	//学生信息保存功能
	public Result save(DbStudent dbStudent);
	
	//修改密码
	public Result updatepass(DbStudent dbStudent);
	
}
