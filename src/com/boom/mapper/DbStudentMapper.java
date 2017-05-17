package com.boom.mapper;

import com.boom.pojo.DbStudent;



/**
 * 学生类查询接口
 * @author Administrator
 *
 */
public interface DbStudentMapper {
	
	//按学号查询学生
	public DbStudent findStudentBySnumber(DbStudent dbStudent);
	
	//添加学生
	public void insertStudent(DbStudent dbStudent);
	
	//保存学生信息
	public void saveStudent(DbStudent dbStudent);
	
	//修改密码
	public void updatepass(DbStudent dbStudent);
}
