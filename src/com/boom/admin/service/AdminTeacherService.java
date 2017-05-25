package com.boom.admin.service;

import com.boom.pojo.DbTeacher;
import com.boom.pojo.DbTeachercustomer;
import com.boom.utils.PageResult;
import com.boom.utils.Result;

public interface AdminTeacherService {

	PageResult findAll(Integer page);

	Result addTeacher(DbTeacher dbTeacher);

	Result updateTeacher(DbTeacher dbTeacher);

	Result deleteTeacher(String[] ids);

	PageResult selectTeacher(DbTeachercustomer dbTeachercustomer, Integer page);

}
