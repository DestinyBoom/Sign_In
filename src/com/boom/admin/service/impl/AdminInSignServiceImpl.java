package com.boom.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbDayMapper;
import com.boom.admin.mapper.AdminDbInsignMapper;
import com.boom.admin.mapper.AdminDbTeacherMapper;
import com.boom.admin.service.AdminInSignService;
import com.boom.pojo.DbDay;
import com.boom.pojo.DbInSign;
import com.boom.pojo.DbTeacher;
import com.boom.utils.Result;

@Service
public class AdminInSignServiceImpl implements AdminInSignService{
	
	@Autowired
	private AdminDbInsignMapper adminDbInsignMapper;
	@Autowired
	private AdminDbTeacherMapper adminDbTeacherMapper;
	@Autowired
	private AdminDbDayMapper adminDbDayMapper;
	
	@Override
	public Result updateOpenSign() {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		String month = date.substring(0, date.lastIndexOf("-"));
		String day = date.substring(date.lastIndexOf("-") + 1);
		
		Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
		
	    try {
			List<DbTeacher> list = adminDbTeacherMapper.findAll();
			DbInSign dbInSign = new DbInSign();
			dbInSign.setImonth(month);
			DbDay dbDay = new DbDay();
			dbDay.setImonth(month);
			for(DbTeacher dTeacher:list){
				dbInSign.setAid(dTeacher.getAid());
				dbInSign.setTid(dTeacher.getTid());
				DbInSign dbInSign2 = adminDbInsignMapper.selectByMonthTid(dbInSign);
				if(dbInSign2 == null){
					int rows = adminDbInsignMapper.insert(dbInSign);
					if(rows == 0){
						return Result.build(500, "插入数据失败");
					}
					
					dbDay.setTid(dTeacher.getTid());
					for (int i = 1; i <= maxDate; i++) {
						if (i < 10) {
							dbDay.setDname("0" + i);
						} else {
							dbDay.setDname(i + "");
						}
						rows = adminDbDayMapper.insert(dbDay);
						if(rows == 0){
							return Result.build(503, "插入数据失败");
						}						
					}
					dbDay.setDname(day);
					dbDay.setStatus(2);
					rows = adminDbDayMapper.update(dbDay);
					if(rows == 0){
						return Result.build(504, "修改数据失败");
					}
				}
				
				int rows = adminDbInsignMapper.updateState(dbInSign);
				if(rows == 0){
					return Result.build(501, "修改数据失败");
				}
				rows = adminDbInsignMapper.updateShouldSign(dbInSign);
				if(rows == 0){
					return Result.build(502, "修改数据失败");
				}			
			}
			return Result.build(200, "开启签到成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "开启签到失败");
		}
		
	}

}
