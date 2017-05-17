package com.boom.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.mapper.DbDayMapper;
import com.boom.mapper.DbInSignMapper;
import com.boom.mapper.DbTeacherMapper;
import com.boom.pojo.DbDay;
import com.boom.pojo.DbInSign;
import com.boom.pojo.DbTeacher;
import com.boom.service.SignInService;
import com.boom.utils.Result;

@Service
public class SignServiceImpl implements SignInService{
	
	@Autowired
	private DbInSignMapper dbInSignMapper;
	@Autowired
	private DbDayMapper dbDayMapper;
	@Autowired
	private DbTeacherMapper dbTeacherMapper;
	
	@Override
	public Result updateOk(DbTeacher dbTeacher) {
		SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat dfd = new SimpleDateFormat("dd");
		String day = "";
		Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
		
	    try {
			dbTeacher = dbTeacherMapper.findTeacherByTid(dbTeacher.getTid());
			DbInSign dbInSign = new DbInSign();
			dbInSign.setImonth(dfm.format(new Date()));
			dbInSign.setTid(dbTeacher.getTid());			
			dbInSign = dbInSignMapper.selectByMonth(dbInSign);
			
			DbDay dbDay = new DbDay();
			dbDay.setTid(dbTeacher.getTid());
			if (dbInSign == null) {
				DbInSign dbInSign2 = new DbInSign();
				System.out.println(dbTeacher);
				dbInSign2.setAid(dbTeacher.getAid());
				dbInSign2.setTid(dbTeacher.getTid());
				dbInSign2.setImonth(dfm.format(new Date()));
				dbInSignMapper.insert(dbInSign2);
				dbInSign = dbInSignMapper.selectByMonth(dbInSign2);
				
				dbDay.setImonth(dfm.format(new Date()));
				dbDay.setTid(dbTeacher.getTid());
				for (int i = 1; i <= maxDate; i++) {
					if (i < 10) {
						dbDay.setDname(day = "0" + i);
					} else {
						dbDay.setDname(day = i + "");
					}
					dbDayMapper.insert(dbDay);
				}
			}
			
			dbDay.setImonth(dfm.format(new Date()));
			day = dfd.format(new Date());
			dbDay.setDname(day);
			dbDay = dbDayMapper.selectDayByStatus(dbDay);
			if (dbDay.getStatus() == 1) {
				return Result.build(200, "今天已经签到",dbDay.getStatus());
			} else if(dbDay.getStatus() == 2){
				dbDay.setStatus(1);
				dbDayMapper.update(dbDay);
				dbInSignMapper.update(dbDay);
				return Result.build(200, "签到成功",dbDay.getStatus());
			}else{
				return Result.build(200, "暂时还没开启签到",dbDay.getStatus());
			} 
	    }catch (Exception e) {
			return Result.build(500, "失败");
	    }
	}

}
