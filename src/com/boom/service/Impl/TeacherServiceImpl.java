package com.boom.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbTeacherMapper;
import com.boom.mapper.DbTeacherMapper;
import com.boom.pojo.DbTeacher;
import com.boom.service.TeacherService;
import com.boom.utils.Result;

/**
 * 教师类业务实现类
 * @author Administrator
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private DbTeacherMapper dbTeacherMapper;
	@Autowired
	private AdminDbTeacherMapper adminDbTeacherMapper;
	
	@Override
	public Result login(DbTeacher dbTeacher) {
		try {
			if(dbTeacher==null){
				return Result.build(501, "未收到传输的用户名及密码","无");
			}
			DbTeacher data = dbTeacherMapper.findTeacherByTnumber(dbTeacher);
			if(data == null){
				return Result.build(502, "查无此人");
			}
			if(data.getTuuid() == null){
				dbTeacherMapper.insertTuuid(dbTeacher);
				data.setTuuid(dbTeacher.getTuuid());
			} 
			if(data.getTnumber().equals(dbTeacher.getTnumber()) && data.getTpass().equals(dbTeacher.getTpass())){
				if(data.getTuuid().equals(dbTeacher.getTuuid())){
					return Result.build(200, "登录成功", data);
				}
				return Result.build(503, "不是本人登录");
			}else{
				return Result.build(504, "用户名或密码错误");
			}
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}

	@Override
	public Result regist(DbTeacher dbTeacher) {
		try {
			List<DbTeacher> list = adminDbTeacherMapper.getAll();
			for(DbTeacher dTeacher:list){
				if(dTeacher.getTuuid().equals(dbTeacher.getTuuid())){
					return Result.build(502, "注册失败,该设备已经注册!");
				}
			}
			
			int rows = dbTeacherMapper.insertTeacher(dbTeacher);
			if(rows == 0){
				return Result.build(501, "插入失败,用户名重复");
			}
			return Result.build(200, "注册成功", "无");
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}

	@Override
	public Result save(DbTeacher dbTeacher) {
		try {
			int rows = dbTeacherMapper.saveTeacher(dbTeacher);
			if(rows == 0){
				return Result.build(501, "保存失败,用户名不存在");
			}
			return Result.build(200, "保存成功", "无");
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}

	@Override
	public Result updatepass(DbTeacher dbTeacher) {
		try {
			int rows = dbTeacherMapper.updatepass(dbTeacher);
			if(rows == 0){
				return Result.build(501, "修改失败,用户名不存在");
			}
			return Result.build(200, "修改成功", "无");
		} catch (Exception e) {
			return Result.build(500, "传入数据有误或服务器错误");
		}
	}
}
