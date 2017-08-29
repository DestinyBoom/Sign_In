package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbDay;
import com.boom.pojo.DbDayCustomer;

public interface AdminDbDayMapper {

	int insert(DbDay dbDay);

	int update(DbDay dbDay);

	List<DbDay> selectByIid(Integer iid);

	List<DbDay> selectByIidAndDay(DbDay dbDay);

	int updateStatus(DbDay dbDay);

	List<DbDay> selectByTidAndMonth(DbDay dbDay);

	List<DbDay> selectDxByIid(Integer iid);

	List<DbDayCustomer> selectByIidAndDay_SignIn(DbDay dbDay);

}
