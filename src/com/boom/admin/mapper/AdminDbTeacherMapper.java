package com.boom.admin.mapper;

import java.util.List;

import com.boom.pojo.DbTeacher;
import com.boom.pojo.DbTeachercustomer;

public interface AdminDbTeacherMapper {

	List<DbTeacher> getAll();

	List<DbTeacher> findAll();

	int addTeacher(DbTeacher dbTeacher);

	int updateTeacher(DbTeacher dbTeacher);

	int deleteTeacher(String[] ids);

	List<DbTeachercustomer> selectTeacher(DbTeachercustomer dbTeachercustomer);

	DbTeachercustomer selectByTid(Integer tid);

}
 