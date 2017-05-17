package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbAcademy;

/**
 * 学院类的mapper接口
 * @author Administrator
 *
 */
public interface AdminDbAcademyMapper {
	
	//查询所有学院信息
	public List<DbAcademy> findAll();
	
	//添加学院
	public int addAcademy(DbAcademy dbAcademy);
	
	//更改学院
	public int updateAcademy(DbAcademy dbAcademy);
	
	//删除学院
	public int deleteAcademy(String[] ids);
}
