package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbStudent;
import com.boom.pojo.DbStudentCustomer;

/**
 * 学生类的mapper接口
 * @author Administrator
 *
 */
public interface AdminDbStudentMapper {
	
	//查询所有学生信息
	public List<DbStudent> findAll();
	
	//添加学生信息
	public int addStudent(DbStudent dbStudent);
	
	//修改学生信息
	public int updateStudent(DbStudent dbStudent);
	
	//删除学生信息
	public int deleteStudent(String[] ids);
	
	//多条件组合查询
	public List<DbStudentCustomer> selectStudent(DbStudentCustomer dbStudentCustomer);
	
}
