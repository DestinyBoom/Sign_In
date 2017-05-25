package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbOperateMapper;
import com.boom.admin.service.AdminOperateService;
import com.boom.pojo.DbOperate;
import com.boom.utils.Result;

@Service
public class AdminOperateServiceImpl implements AdminOperateService{
	
	@Autowired
	private AdminDbOperateMapper adminDbOperateMapper;
	
	@Override
	public Result findAll() {
		try {
			List<DbOperate> list = adminDbOperateMapper.findAll();
			return Result.build(200, "查询成功",list);
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}	
	}

	@Override
	public Result addOperate(DbOperate dbOperate) {
		try {
			int rows = adminDbOperateMapper.addOperate(dbOperate);
			if(rows == 0){
				Result.build(501, "该操作已经存在");
			}
			return Result.build(200, "添加成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public Result updateOperate(DbOperate dbOperate) {
		try {
			int rows = adminDbOperateMapper.updateOperate(dbOperate);
			if(rows == 0){
				return Result.build(501, "该操作不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public Result deleteOperate(String[] ids) {
		try {
			int rows = adminDbOperateMapper.deleteOperate(ids);
			if(rows == 0){
				return Result.build(501, "该操作不存在,该id无效");
			}
			return Result.build(200, "删除成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

}
