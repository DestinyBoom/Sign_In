package com.boom.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Result login(DbTeacher dbTeacher) {
		try {
			DbTeacher data = dbTeacherMapper.findTeacherByTnumber(dbTeacher);
			if(data.getTnumber().equals(dbTeacher.getTnumber()) && data.getTpass().equals(dbTeacher.getTpass())
					&& data.getTuuid().equals(dbTeacher.getTuuid())){
				return Result.ok(data);
			}else{
				return Result.build(500, "工号或密码错误或不是本人登录");
			}
		} catch (Exception e) {
			return Result.build(500, "工号或密码错误或不是本人登录");
		}
	}

	@Override
	public Result regist(DbTeacher dbTeacher) {
		try {
			dbTeacherMapper.insertTeacher(dbTeacher);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "插入失败,工号重复或其它");
		}
	}

	@Override
	public Result save(DbTeacher dbTeacher) {
		try {
			dbTeacherMapper.saveTeacher(dbTeacher);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "信息录入失败");
		}
	}

	@Override
	public Result updatepass(DbTeacher dbTeacher) {
		try {
			dbTeacherMapper.updatepass(dbTeacher);
			return Result.ok();
		} catch (Exception e) {
			return Result.build(500, "信息录入失败");
		}
	}
}
