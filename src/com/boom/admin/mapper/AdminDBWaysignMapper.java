package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbWaysign;

public interface AdminDBWaysignMapper {

	List<DbWaysign> findAll();

	int updateWaysign(DbWaysign dbWaysign);

}
