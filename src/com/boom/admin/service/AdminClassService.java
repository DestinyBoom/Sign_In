package com.boom.admin.service;

import com.boom.pojo.DbClass;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

/**
 * 班级业务接口
 * @author Administrator
 *
 */
public interface AdminClassService {
	
	//查询
	PageResult findAll(Integer page);
	
	//添加
	Result addClass(DbClass dbClass);
	
	//改变
	Result updateClass(DbClass dbClass);
	
	//删除
	Result deleteClass(String[] ids);

}
