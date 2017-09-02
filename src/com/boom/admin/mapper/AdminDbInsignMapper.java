package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbInSign;
import com.boom.pojo.DbInSignCustomer;

public interface AdminDbInsignMapper {

	DbInSign selectByMonthTid(DbInSign dbInSign);

	int insert(DbInSign dbInSign);

	int updateState(DbInSign dbInSign);

	int updateShouldSign(DbInSign dbInSign);

	int updateCloseSign(DbInSign dbInSign);

	List<DbInSignCustomer> findTByMonth(DbInSignCustomer dbInSignCustomer);

	List<DbInSignCustomer> findAll();

	int updateRetroactiveInsign(DbInSign dbInSign);

}
