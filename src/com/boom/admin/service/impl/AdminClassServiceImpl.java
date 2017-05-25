package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbClassMapper;
import com.boom.admin.service.AdminClassService;
import com.boom.pojo.DbClass;
import com.boom.utils.Result;

/**
 * 班级业务实现类
 * @author Administrator
 *
 */
@Service
public class AdminClassServiceImpl implements AdminClassService{
	
	@Autowired
	private AdminDbClassMapper adminDbClassMapper;
	
	//查
	@Override
	public Result findAll() {
		try {
			List<DbClass> list = adminDbClassMapper.findAll();
			return Result.build(200, "查询成功",list);
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}	
	}
	
	//增
	@Override
	public Result addClass(DbClass dbClass) {
		try {
			int rows = adminDbClassMapper.addClass(dbClass);
			if(rows == 0){
				Result.build(501, "该班级已经存在");
			}
			return Result.build(200, "添加成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}
	
	//改
	@Override
	public Result updateClass(DbClass dbClass) {
		try {
			int rows = adminDbClassMapper.updateClass(dbClass);
			if(rows == 0){
				return Result.build(501, "该班级不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}
	
	//删
	@Override
	public Result deleteClass(String[] ids) {
		try {
			int rows = adminDbClassMapper.deleteClass(ids);
			if(rows == 0){
				return Result.build(501, "该班级不存在,该id无效");
			}
			return Result.build(200, "删除成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

}
