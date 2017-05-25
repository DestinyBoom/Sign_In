package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbOperate;

public interface AdminDbOperateMapper {
	
	List<DbOperate> findAll();

	int addOperate(DbOperate dbOperate);

	int updateOperate(DbOperate dbOperate);

	int deleteOperate(String[] ids);
}
