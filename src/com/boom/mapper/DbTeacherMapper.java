package com.boom.mapper;

import com.boom.pojo.DbTeacher; 

/**
 * 教师类查询接口
 * @author Administrator
 *
 */
public interface DbTeacherMapper {

	DbTeacher findTeacherByTnumber(DbTeacher dbTeacher);

	int insertTeacher(DbTeacher dbTeacher);

	int saveTeacher(DbTeacher dbTeacher);

	int updatepass(DbTeacher dbTeacher);

	DbTeacher findTeacherByTid(Integer tid);

	int insertTuuid(DbTeacher dbTeacher);

}
