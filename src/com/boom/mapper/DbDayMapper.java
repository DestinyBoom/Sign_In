package com.boom.mapper;

import com.boom.pojo.DbDay;

public interface DbDayMapper {

	DbDay selectDayByStatus(DbDay dbDay);
	
	void insert(DbDay dbDay);
	
	void update(DbDay dbDay);	
}
