package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbTeacherMapper;
import com.boom.admin.service.AdminTeacherService;
import com.boom.pojo.DbTeacher;
import com.boom.pojo.DbTeachercustomer;
import com.boom.utils.Const;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AdminTeacherServiceImpl implements AdminTeacherService{

	@Autowired
	private AdminDbTeacherMapper adminDbTeacherMapper;
	
	@Override
	public PageResult findAll(Integer page) {
		if(page == null || page < 0){
			page = 1;
		}
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbTeacher> list = adminDbTeacherMapper.findAll();
		result.setRows(list);
		PageInfo<DbTeacher> pageInfo = new PageInfo<DbTeacher>(list);
		result.setTotal(pageInfo.getTotal());
		return result;	
	}

	@Override
	public Result addTeacher(DbTeacher dbTeacher) {
		try {	
			//System.out.println(dbTeacher);
			int rows = adminDbTeacherMapper.addTeacher(dbTeacher);
			if(rows == 0){
				return Result.build(501, "该老师已经存在");
			}
			return Result.build(200, "添加成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public Result updateTeacher(DbTeacher dbTeacher) {
		try {
			int rows = adminDbTeacherMapper.updateTeacher(dbTeacher);
			if(rows == 0){
				return Result.build(501, "该老师不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public Result deleteTeacher(String[] ids) {
		try {
			int rows = adminDbTeacherMapper.deleteTeacher(ids);
			if(rows == 0){
				return Result.build(501, "该老师不存在,该id无效");
			}
			return Result.build(200, "删除成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public PageResult selectTeacher(DbTeachercustomer dbTeachercustomer,
			Integer page) {
		if(page == null || page < 0){
			page = 1;
		}
		//分页
		List<DbTeachercustomer> list2 = adminDbTeacherMapper.selectTeacher(dbTeachercustomer);
		//System.out.println(list2.toString());
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbTeachercustomer> list = adminDbTeacherMapper.selectTeacher(dbTeachercustomer);
		//System.out.println(list.toString());
		result.setRows(list);
		PageInfo<DbTeachercustomer> pageInfo = new PageInfo<DbTeachercustomer>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
		}
}
