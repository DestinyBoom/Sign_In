package com.boom.mapper;

import com.boom.pojo.DbTeacher; 

/**
 * 教师类查询接口
 * @author Administrator
 *
 */
public interface DbTeacherMapper {

	DbTeacher findTeacherByTnumber(DbTeacher dbTeacher);

	void insertTeacher(DbTeacher dbTeacher);

	void saveTeacher(DbTeacher dbTeacher);

	void updatepass(DbTeacher dbTeacher);

	DbTeacher findTeacherByTid(Integer tid);

}
