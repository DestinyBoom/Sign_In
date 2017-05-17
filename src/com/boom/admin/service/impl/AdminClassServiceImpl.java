package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbClassMapper;
import com.boom.admin.service.AdminClassService;
import com.boom.pojo.DbClass;
import com.boom.pojo.DbStudent;
import com.boom.utils.Const;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public PageResult findAll(Integer page) {
		if(page == null || page < 0){
			page = 1;
		}
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbStudent> list = adminDbClassMapper.findAll();
		result.setRows(list);
		PageInfo<DbStudent> pageInfo = new PageInfo<DbStudent>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	//增
	@Override
	public Result addClass(DbClass dbClass) {
		try {
			int rows = adminDbClassMapper.addClass(dbClass);
			if(rows == 0){
				return Result.build(500, "插入失败");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}
	
	//改
	@Override
	public Result updateClass(DbClass dbClass) {
		try {
			int rows = adminDbClassMapper.updateClass(dbClass);
			if(rows == 0){
				return Result.build(500, "插入失败");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}
	
	//删
	@Override
	public Result deleteClass(String[] ids) {
		try {
			int rows = adminDbClassMapper.deleteClass(ids);
			if(rows == 0){
				return Result.build(500, "删除失败可能已经删除过该id");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}

}
