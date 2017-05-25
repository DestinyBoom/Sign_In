package com.boom.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbAcademyMapper;
import com.boom.admin.service.AdminAcademyService;
import com.boom.pojo.DbAcademy;
import com.boom.utils.Result;

/**
 * 学院业务实现类
 * @author Administrator
 *
 */
@Service
public class AdminAcademyServiceImpl implements AdminAcademyService{
	
	
	@Autowired
	private AdminDbAcademyMapper adminDbAcademyMapper;
	
	//查询学院
	@Override
	public Result findAll() {
		try {
			List<DbAcademy> list = adminDbAcademyMapper.findAll();
			return Result.build(200, "查询成功",list);
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}	
	}
	
	//添加学院
	@Override
	public Result addAcademy(DbAcademy dbAcademy) {
		try {
			int rows = adminDbAcademyMapper.addAcademy(dbAcademy);
			if(rows == 0){
				return Result.build(501, "该学院已经存在");
			}
			return Result.build(200, "添加成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}
	
	//更改学院
	@Override
	public Result updateAcademy(DbAcademy dbAcademy) {
		try {
			int rows = adminDbAcademyMapper.updateAcademy(dbAcademy);
			if(rows == 0){
				return Result.build(501, "该学院不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}
	
	//删除学院
	@Override
	public Result deleteAcademy(String[] ids) {
		try {
			int rows = adminDbAcademyMapper.deleteAcademy(ids);
			if(rows == 0){
				return Result.build(501, "该学院不存在,该id无效");
			}
			return Result.build(200, "删除成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}
	
}
