package com.boom.admin.service;

import com.boom.pojo.DbDay;
import com.boom.pojo.DbInSignCustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

public interface AdminInSignService {

	Result updateOpenSign();

	Result updateCloseSign();

	PageResult findTByMonthAndDay(DbInSignCustomer dbInSignCustomer,
			Integer page);

	Result updateStatus(DbDay dbDay);

}
