package com.boom.service;

import com.boom.pojo.DbTeacher;
import com.boom.utils.Result;

/**
 * 教师类业务接口
 * @author Administrator
 *
 */
public interface TeacherService {

	Result login(DbTeacher dbTeacher);

	Result regist(DbTeacher dbTeacher);

	Result save(DbTeacher dbTeacher);

	Result updatepass(DbTeacher dbTeacher);
	
}
