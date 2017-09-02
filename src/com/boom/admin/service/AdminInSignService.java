package com.boom.admin.service;

import com.boom.pojo.DbDay;
import com.boom.pojo.DbDayCustomer;
import com.boom.pojo.DbInSignCustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageInfo;

public interface AdminInSignService {

	Result updateOpenSign();

	Result updateCloseSign();

	PageResult findTByMonthAndDay(DbInSignCustomer dbInSignCustomer,
			Integer page);

	Result updateStatus(DbDay dbDay);

	PageResult findAll(Integer page);

	PageInfo<DbDayCustomer>findInsignToady(Integer page);

	Result updateRetroactive(String month, String day, Integer tid, String time);

}
