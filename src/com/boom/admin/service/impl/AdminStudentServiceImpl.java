package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbStudentMapper;
import com.boom.admin.service.AdminStudentService;
import com.boom.pojo.DbStudent;
import com.boom.pojo.DbStudentCustomer;
import com.boom.utils.Const;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 管理员管理学生义务实现
 * @author Administrator
 *
 */
@Service
public class AdminStudentServiceImpl implements AdminStudentService{
	
	@Autowired
	private AdminDbStudentMapper adminDbStudentMapper;
	
	//查询所有学生带页数
	@Override
	public PageResult findAll(Integer page) {				
		if(page == null || page < 0){
			page = 1;
		}
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbStudent> list = adminDbStudentMapper.findAll();
		result.setRows(list);
		PageInfo<DbStudent> pageInfo = new PageInfo<DbStudent>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
	}
		
	//添加学生
	@Override
	public Result addStudent(DbStudent dbStudent) {
		try {
			int rows = adminDbStudentMapper.addStudent(dbStudent);
			if(rows == 0){
				return Result.build(500, "插入失败");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}
	
	//修改学生
	@Override
	public Result updateStudent(DbStudent dbStudent) {
		try {
			int rows = adminDbStudentMapper.updateStudent(dbStudent);
			if(rows == 0){
				return Result.build(500, "插入失败");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}
	
	//删除学生
	@Override
	public Result deleteStudent(String[] ids) {				
		try {
			int rows = adminDbStudentMapper.deleteStudent(ids);
			if(rows == 0){
				return Result.build(500, "删除失败可能已经删除过该id");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误");
		}
	}
	
	//高级搜索
	@Override
	public PageResult selectStudent(DbStudentCustomer dbStudentCustomer, Integer page) {
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbStudentCustomer> list = adminDbStudentMapper.selectStudent(dbStudentCustomer);
		System.out.println(list);
		result.setRows(list);
		PageInfo<DbStudentCustomer> pageInfo = new PageInfo<DbStudentCustomer>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
	}
	
}
