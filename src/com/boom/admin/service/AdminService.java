package com.boom.admin.service;

import com.boom.pojo.DbAdmin;

public interface AdminService {

	DbAdmin findAdmin(DbAdmin admin);

	DbAdmin findAdminByUname(String uname);

	int updateAdminPass(DbAdmin admin);

}
