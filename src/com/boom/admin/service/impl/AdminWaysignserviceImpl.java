package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDBWaysignMapper;
import com.boom.admin.service.AdminWaysignservice;
import com.boom.pojo.DbWaysign;
import com.boom.utils.Result;

@Service
public class AdminWaysignserviceImpl implements AdminWaysignservice{

	@Autowired
	private AdminDBWaysignMapper adminDBWaysignMapper;
	
	@Override
	public Result findAll() {
		try {
			List<DbWaysign> list = adminDBWaysignMapper.findAll();
			return Result.build(200, "查询成功",list);
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}	
	}

	@Override
	public Result updateWaysign(DbWaysign dbWaysign) {
		try {
			int rows = adminDBWaysignMapper.updateWaysign(dbWaysign);
			if(rows == 0){
				return Result.build(501, "数据不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

}
