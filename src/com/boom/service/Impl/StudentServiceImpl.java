package com.boom.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.mapper.DbStudentMapper;
import com.boom.pojo.DbStudent;
import com.boom.service.StudentService;
import com.boom.utils.Result;


/**
 * 学生业务实现类
 * @author Administrator
 *
 */
@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private DbStudentMapper dbStudentMapper;
	
	//登录功能实现方法
	@Override
	public Result login(DbStudent dbStudent) {
		try {
			DbStudent data = dbStudentMapper.findStudentBySnumber(dbStudent);
			if(data == null){
				return Result.build(502, "查无此人");
			}
			if(data.getSnumber().equals(dbStudent.getSnumber()) && data.getSpass().equals(dbStudent.getSpass())){
				return Result.build(200, "登录成功", data);
			}else{
				return Result.build(501, "学号或密码错误");
			}
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
		
	}
	
	//注册功能实现方法
	@Override
	public Result regist(DbStudent dbStudent) {
		try {
			int rows = dbStudentMapper.insertStudent(dbStudent);
			if(rows == 0){
				return Result.build(501, "插入失败,用户名重复");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}
	
	//信息保存功能实现方法
	@Override
	public Result save(DbStudent dbStudent) {
		try {
			int rows = dbStudentMapper.saveStudent(dbStudent);
			if(rows == 0){
				return Result.build(501, "保存失败,用户名不存在");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}

	@Override
	public Result updatepass(DbStudent dbStudent) {
		try {
			int rows = dbStudentMapper.updatepass(dbStudent);
			if(rows == 0){
				return Result.build(501, "修改失败,用户名不存在");
			}
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}

}
