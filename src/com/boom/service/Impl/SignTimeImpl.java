package com.boom.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boom.admin.mapper.AdminDbOperateMapper;
import com.boom.admin.service.AdminInSignService;
import com.boom.pojo.DbOperate;

@Service
public class SignTimeImpl {
	
	@Autowired
	private AdminInSignService adminInSignService;
	@Autowired
	private AdminDbOperateMapper adminDbOperateMapper;
	
	public void openSign(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		String time = simpleDateFormat.format(date);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(!isWeekend(cal)){
			try {
				date = simpleDateFormat.parse(time);
				//System.out.println(time);
				List<DbOperate> list = adminDbOperateMapper.findAll();
				
				for(DbOperate dOperate:list){
					Date startTime = simpleDateFormat.parse(dOperate.getStarttime());
					Date stopTime = simpleDateFormat.parse(dOperate.getStoptime());
					if(date.getTime()==startTime.getTime()){
						adminInSignService.updateOpenSign();
						//System.out.println(dOperate.getOname() +"开启了");
					}
					if(date.getTime()==stopTime.getTime()){
						adminInSignService.updateCloseSign();
						//System.out.println(dOperate.getOname() +"关闭了");
					}	
				}	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("不是周末");
		}else{
			//System.out.println("是周末");
		}
	}
	
	/** 
	 * 判断是否是周末 
	 * @return 
	 */  
	private boolean isWeekend(Calendar cal){  
	    int week=cal.get(Calendar.DAY_OF_WEEK)-1;  
	    if(week ==6 || week==0){//0代表周日，6代表周六  
	        return true;  
	    }  
	    return false;  
	}
}
