package com.boom.admin.service;

import com.boom.pojo.DbAcademy;
import com.boom.utils.Result;
	
/**
 * 学院类业务接口
 * @author Administrator
 *
 */
public interface AdminAcademyService {
	
	//查询所有学院
	Result findAll();
	
	//添加学院
	Result addAcademy(DbAcademy dbAcademy);
	
	//更改学院
	Result updateAcademy(DbAcademy dbAcademy);
	
	//删除学院
	Result deleteAcademy(String[] ids);
}
