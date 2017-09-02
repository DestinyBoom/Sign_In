package com.boom.admin.mapper;

import com.boom.pojo.DbAdmin;

public interface AdminMapper {

	DbAdmin findAdmin(DbAdmin admin);

	DbAdmin findAdminByUname(String uname);

	int updateAdminPass(DbAdmin admin);

}
