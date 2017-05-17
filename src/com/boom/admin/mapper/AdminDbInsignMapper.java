package com.boom.admin.mapper;

import com.boom.pojo.DbInSign;

public interface AdminDbInsignMapper {

	DbInSign selectByMonthTid(DbInSign dbInSign);

	int insert(DbInSign dbInSign);

	int updateState(DbInSign dbInSign);

	int updateShouldSign(DbInSign dbInSign);

}
