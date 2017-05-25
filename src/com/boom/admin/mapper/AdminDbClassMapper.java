package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbClass;

/**
 * 班级管理mapper接口
 * @author Administrator
 *
 */
public interface AdminDbClassMapper {
	
	//查
	List<DbClass> findAll();
	
	//增
	int addClass(DbClass dbClass);
	
	//改
	int updateClass(DbClass dbClass);
	
	//删
	int deleteClass(String[] ids);			
}
