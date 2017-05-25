package com.boom.admin.service;

import com.boom.pojo.DbWaysign;
import com.boom.utils.Result;

public interface AdminWaysignservice {

	Result findAll();

	Result updateWaysign(DbWaysign dbWaysign);

}
