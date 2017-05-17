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
			if(data.getSnumber().equals(dbStudent.getSnumber()) && data.getSpass().equals(dbStudent.getSpass())){
				return Result.ok(data);
			}else{
				return Result.build(500, "学号或密码错误");
			}
		} catch (Exception e) {
			return Result.build(500, "学号或密码错误");
		}
		
	}
	
	//注册功能实现方法
	@Override
	public Result regist(DbStudent dbStudent) {
		try {
			dbStudentMapper.insertStudent(dbStudent);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "插入失败,学号重复或其它");
		}
	}
	
	//信息保存功能实现方法
	@Override
	public Result save(DbStudent dbStudent) {
		try {
			dbStudentMapper.saveStudent(dbStudent);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "信息录入失败");
		}
	}

	@Override
	public Result updatepass(DbStudent dbStudent) {
		try {
			dbStudentMapper.updatepass(dbStudent);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "信息录入失败");
		}
	}

}
