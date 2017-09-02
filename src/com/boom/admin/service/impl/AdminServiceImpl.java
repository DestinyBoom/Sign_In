package com.boom.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminMapper;
import com.boom.admin.service.AdminService;
import com.boom.pojo.DbAdmin;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;
	
	public DbAdmin findAdmin(DbAdmin admin) {
		
		return adminMapper.findAdmin(admin);
	}

	public DbAdmin findAdminByUname(String uname) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminByUname(uname);
	}

	public int updateAdminPass(DbAdmin admin) {
		// TODO Auto-generated method stub
		return adminMapper.updateAdminPass(admin);
	}

}
