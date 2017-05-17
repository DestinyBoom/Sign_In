package com.boom.mapper;

import com.boom.pojo.DbDay;
import com.boom.pojo.DbInSign;

public interface DbInSignMapper {

	DbInSign selectByMonth(DbInSign dbInSign);

	void insert(DbInSign dbInSign);

	void update(DbDay dbDay);
	
}
