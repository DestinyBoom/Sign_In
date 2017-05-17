package com.boom.admin.service;

import com.boom.pojo.DbStudent;
import com.boom.pojo.DbStudentCustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

/**
 * 管理员管理学生业务接口
 * @author Administrator
 *
 */
public interface AdminStudentService {
	
	//查看所有学生
	PageResult findAll(Integer page);
	
	//添加学生
	Result addStudent(DbStudent dbStudent);
	
	//修改学生
	Result updateStudent(DbStudent dbStudent);
	
	//删除学生
	Result deleteStudent(String[] ids);
	
	//高级搜索
	PageResult selectStudent(DbStudentCustomer dbStudentCustomer, Integer page);	
}
