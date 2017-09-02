package com.boom.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDBWaysignMapper;
import com.boom.admin.mapper.AdminDbAcademyMapper;
import com.boom.admin.mapper.AdminDbDayMapper;
import com.boom.admin.mapper.AdminDbInsignMapper;
import com.boom.admin.mapper.AdminDbOperateMapper;
import com.boom.admin.mapper.AdminDbTeacherMapper;
import com.boom.admin.service.AdminInSignService;
import com.boom.pojo.DbDay;
import com.boom.pojo.DbDayCustomer;
import com.boom.pojo.DbInSign;
import com.boom.pojo.DbInSignCustomer;
import com.boom.pojo.DbTeacher;
import com.boom.pojo.DbTeachercustomer;
import com.boom.utils.Const;
import com.boom.utils.PageResult;
import com.boom.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AdminInSignServiceImpl implements AdminInSignService{
	
	@Autowired
	private AdminDbInsignMapper adminDbInsignMapper;
	@Autowired
	private AdminDbTeacherMapper adminDbTeacherMapper;
	@Autowired
	private AdminDbDayMapper adminDbDayMapper;
	@Autowired
	private AdminDbAcademyMapper adminDbAcademyMapper;
	@Autowired
	private AdminDBWaysignMapper adminDBWaysignMapper;
	
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
			List<DbTeacher> list = adminDbTeacherMapper.getAll();
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
						return Result.build(502, "添加数据失败");
					}
					dbInSign = adminDbInsignMapper.selectByMonthTid(dbInSign);
					
					if(adminDbInsignMapper.selectByMonthTid(dbInSign).getState() == 1){
						return Result.build(201, "签到已经开启,请不要重复操作");
					}
					
					rows = adminDbInsignMapper.updateState(dbInSign);
					if(rows == 0){
						return Result.build(501, "修改数据失败了");
					}
					rows = adminDbInsignMapper.updateShouldSign(dbInSign);
					if(rows == 0){
						return Result.build(501, "修改数据失败了！");
					}		
					
					dbDay.setIid(dbInSign.getIid());
					dbDay.setTid(dTeacher.getTid());
					for (int i = 1; i <= maxDate; i++) {
						if (i < 10) {
							dbDay.setDname("0" + i);
						} else {
							dbDay.setDname(i + "");
						}
						System.out.println(dbDay);
						rows = adminDbDayMapper.insert(dbDay);
						if(rows == 0){
							return Result.build(502, "添加数据失败了");
						}						
					}
					dbDay.setDname(day);
					dbDay.setStatus(2);
					
					rows = adminDbDayMapper.update(dbDay);
					if(rows == 0){
						return Result.build(501, "修改数据失败");
					}
				}else{
					if(adminDbInsignMapper.selectByMonthTid(dbInSign).getState() == 1){
						return Result.build(201, "签到已经开启,请不要重复操作");
					}
					
					int rows = adminDbInsignMapper.updateState(dbInSign);
					if(rows == 0){
						return Result.build(501, "修改数据失败了");
					}
					rows = adminDbInsignMapper.updateShouldSign(dbInSign);
					if(rows == 0){
						return Result.build(501, "修改数据失败了！");
					}		
					
					dbDay.setTid(dTeacher.getTid());
					dbDay.setDname(day);
					dbDay.setStatus(2);

					System.out.println(adminDbDayMapper.selectByTidAndMonth(dbDay));
					if(adminDbDayMapper.selectByTidAndMonth(dbDay).size() == 0){
						dbInSign = adminDbInsignMapper.selectByMonthTid(dbInSign);
						dbDay.setIid(dbInSign.getIid());
						dbDay.setTid(dTeacher.getTid());
						for (int i = 1; i <= maxDate; i++) {
							if (i < 10) {
								dbDay.setDname("0" + i);
							} else {
								dbDay.setDname(i + "");
							}
							System.out.println(dbDay);
							rows = adminDbDayMapper.insert(dbDay);
							if(rows == 0){
								return Result.build(502, "添加数据失败了");
							}						
						}
					}
					dbDay.setTid(dTeacher.getTid());
					dbDay.setDname(day);
					dbDay.setStatus(2);
					rows = adminDbDayMapper.update(dbDay);
					if(rows == 0){
						return Result.build(501, "修改数据失败了");
					}
				}
					
			}
			adminDBWaysignMapper.updateWaysignState(1);
			return Result.build(200, "开启签到成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "传入参数有误或者服务器错误");
		}
		
	}

	@Override
	public Result updateCloseSign() {
		try {
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			String date = sm.format(new Date());
			String month = date.substring(0, date.lastIndexOf("-"));
			//String day = date.substring(date.lastIndexOf("-") + 1);
			
			List<DbTeacher> list = adminDbTeacherMapper.getAll();
			DbInSign dbInSign = new DbInSign();
			dbInSign.setImonth(month);
			for(DbTeacher dTeacher:list){
				dbInSign.setAid(dTeacher.getAid());
				dbInSign.setTid(dTeacher.getTid());
				if(adminDbInsignMapper.selectByMonthTid(dbInSign).getState() == 0){
					return Result.build(201, "签到已经关闭,不要重复操作");
				}
				int rows = adminDbInsignMapper.updateCloseSign(dbInSign);
				if(rows == 0){
					return Result.build(501, "修改数据失败");
				}
			}
			adminDBWaysignMapper.updateWaysignStatedel(1);
			return Result.build(200, "关闭签到成功");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public PageResult findTByMonthAndDay(DbInSignCustomer dbInSignCustomer,
			Integer page) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		String month = date.substring(0, date.lastIndexOf("-"));
		String day = date.substring(date.lastIndexOf("-") + 1);
		
		DbDay dbDay = new DbDay();
		if(page == null || page < 0){
			page = 1;
		}

		if(dbInSignCustomer.getImonth() == null ){
			dbInSignCustomer.setImonth(month);
			dbDay.setDname(day);
		}else{
			if(dbInSignCustomer.getDay() != null ){
				dbDay.setDname(dbInSignCustomer.getDay().getDname());
			}
		}
		
		List<DbInSignCustomer> list;
		List<DbInSignCustomer> ls = new ArrayList<DbInSignCustomer>();
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		
		if(dbInSignCustomer.getDbTeacher() != null){
			DbTeachercustomer dbTeachercustomer = new DbTeachercustomer();
			dbTeachercustomer.setTname(dbInSignCustomer.getDbTeacher().getTname());
			List<DbTeachercustomer> listTeacher = adminDbTeacherMapper.selectTeacher(dbTeachercustomer);
			for(DbTeachercustomer dTeachercustomer:listTeacher){
				dbInSignCustomer.setTid(dTeachercustomer.getTid());
				list = adminDbInsignMapper.findTByMonth(dbInSignCustomer);
				
				for(DbInSignCustomer dCustomer : list){
					if(dCustomer.getIid() != null){
						dbDay.setIid(dCustomer.getIid());			
						List<DbDay> dbDays = adminDbDayMapper.selectByIidAndDay(dbDay);
						dCustomer.setDbDay(dbDays);
						ls.add(dCustomer);
						
						System.out.println(ls);
						result.setRows(ls);
						PageInfo<DbInSignCustomer> pageInfo = new PageInfo<DbInSignCustomer>(list);
						result.setTotal(pageInfo.getTotal());				
					}
				}
			}
			return result;
		}else{
			list = adminDbInsignMapper.findTByMonth(dbInSignCustomer);
			for(DbInSignCustomer dCustomer : list){
				if(dCustomer.getIid() != null){
					dbDay.setIid(dCustomer.getIid());			
					List<DbDay> dbDays = adminDbDayMapper.selectByIidAndDay(dbDay);
					dCustomer.setDbDay(dbDays);
					ls.add(dCustomer);
					
					System.out.println(ls);
					result.setRows(ls);
					PageInfo<DbInSignCustomer> pageInfo = new PageInfo<DbInSignCustomer>(list);
					result.setTotal(pageInfo.getTotal());
				}
			}
			return result;
		}
	}

	@Override
	public Result updateStatus(DbDay dbDay) {
		try {
			int rows = adminDbDayMapper.updateStatus(dbDay);
			if(rows == 0){
				return Result.build(501, "该记录不存在");
			}
			return Result.build(200, "修改成功","无");
		} catch (Exception e) {
			return Result.build(500, "传入参数有误或者服务器错误");
		}
	}

	@Override
	public PageResult findAll(Integer page) {
		if(page == null || page < 0){
			page = 1;
		}
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		String month = date.substring(0, date.lastIndexOf("-"));
		String day = date.substring(date.lastIndexOf("-") + 1);
		//分页
		PageHelper.startPage(page, Const.PAGE);
		PageResult result = new PageResult();
		List<DbInSignCustomer> list = adminDbInsignMapper.findAll();
		List<DbInSignCustomer> ls = new ArrayList<DbInSignCustomer>();
		
		for(DbInSignCustomer dbInSignCustomer:list){
			List<DbDay> dbDays = adminDbDayMapper.selectDxByIid(dbInSignCustomer.getIid());
			List<DbDay> ld = new ArrayList<DbDay>();
			for(DbDay dbDay:dbDays){
				if(dbDay.getImonth().equals(month)){
					if(Integer.parseInt(dbDay.getDname()) <= Integer.parseInt(day)){
						ld.add(dbDay);
					}
				}else{
					ld.add(dbDay);
				}
			}
			System.out.println(ld);
			dbInSignCustomer.setDbDay(ld);
			ls.add(dbInSignCustomer);
			result.setRows(ls);
			PageInfo<DbInSignCustomer> pageInfo = new PageInfo<DbInSignCustomer>(list);
			result.setTotal(pageInfo.getTotal());
		}
		return result;
	}

	@Override
	public PageInfo<DbDayCustomer> findInsignToady(Integer page) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		String month = date.substring(0, date.lastIndexOf("-"));
		String day = date.substring(date.lastIndexOf("-") + 1);
		
		DbDay dbDay = new DbDay();
		
		if(page == null || page < 0){
			page = 1;
		}

		//分页
		PageHelper.startPage(page, Const.PAGE);
		
		dbDay.setImonth(month);
		dbDay.setDname(day);
		List<DbDayCustomer> dbDays = adminDbDayMapper.selectByIidAndDay_SignIn(dbDay);
		for(DbDayCustomer dbd : dbDays){
			DbTeachercustomer dbTeacher = adminDbTeacherMapper.selectByTid(dbd.getTid()); 
			dbTeacher.setDbAcademy(adminDbAcademyMapper.findByAid(dbTeacher.getAid()));
			dbd.setDbTeacher(dbTeacher);
		}
		return new PageInfo<DbDayCustomer>(dbDays);
	}

	@Override
	public Result updateRetroactive(String month, String day, Integer tid,
			String time) {
		DbInSign dbInSign = new DbInSign();
		dbInSign.setImonth(month);
		dbInSign.setTid(tid);
		
		DbDay dbday = new DbDay();
		dbday.setImonth(month);
		dbday.setDname(day);
		dbday.setTid(tid);
		dbday.setDtime(time);
		
		int status = adminDbInsignMapper.updateRetroactiveInsign(dbInSign);
		int status2 = adminDbDayMapper.updateRetroactiveDbDay(dbday);
		if(status != 0 && status2 != 0){
			return Result.ok();
		}else{
			return Result.build(5000, "修改失败");
		}
	}	

}
