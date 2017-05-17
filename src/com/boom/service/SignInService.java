package com.boom.service;

import com.boom.pojo.DbTeacher;
import com.boom.utils.Result;

public interface SignInService {
	
	//签到
	Result updateOk(DbTeacher dbTeacher);

}
