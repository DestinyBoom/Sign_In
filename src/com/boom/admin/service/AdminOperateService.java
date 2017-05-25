package com.boom.admin.service;

import com.boom.pojo.DbOperate;
import com.boom.utils.Result;

public interface AdminOperateService {
	
	//查询
	Result findAll();
	
	//添加
	Result addOperate(DbOperate dbOperate);
	
	//改变
	Result updateOperate(DbOperate dbOperate);
	
	//删除
	Result deleteOperate(String[] ids);
}
