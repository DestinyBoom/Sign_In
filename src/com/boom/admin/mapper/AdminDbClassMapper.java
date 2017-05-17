package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbClass;
import com.boom.pojo.DbStudent;

/**
 * 班级管理mapper接口
 * @author Administrator
 *
 */
public interface AdminDbClassMapper {
	
	//查
	List<DbStudent> findAll();
	
	//增
	int addClass(DbClass dbClass);
	
	//改
	int updateClass(DbClass dbClass);
	
	//删
	int deleteClass(String[] ids);			
}
