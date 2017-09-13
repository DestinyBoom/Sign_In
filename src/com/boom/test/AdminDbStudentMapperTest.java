/**
 * 
 */
package com.boom.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.boom.admin.mapper.AdminDbStudentMapper;
import com.boom.pojo.DbStudent;
import com.boom.pojo.DbStudentCustomer;

/**
 * @author Administrator
 *
 */
public class AdminDbStudentMapperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}
	
	public static void main(String[] args) {
		AdminDbStudentMapper adminDbStudentMapper = new AdminDbStudentMapper() {
			
			@Override
			public int updateStudent(DbStudent dbStudent) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public List<DbStudentCustomer> selectStudent(
					DbStudentCustomer dbStudentCustomer) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<DbStudent> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int deleteStudent(String[] ids) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int addStudent(DbStudent dbStudent) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		DbStudent dbStudent = new DbStudent();
		int size=100;
		for(int i=1; i<size; i++){
			dbStudent.setSname("雷梦黎"+i);
			if(i%2==0){
				dbStudent.setSsex("女");
				dbStudent.setAid(2);
				dbStudent.setCid(1);
				dbStudent.setSdate("2016");
			}else{
				dbStudent.setSsex("男");
				dbStudent.setAid(1);
				dbStudent.setCid(2);
				dbStudent.setSdate("2015");
			}
			if(i<10){
				dbStudent.setSnumber("25111502"+0+i);
			}else{
				dbStudent.setSnumber("25111502"+i);
			}
			dbStudent.setSage(20);
			dbStudent.setIsSchool(1);
			//System.out.println(dbStudent);
			adminDbStudentMapper.addStudent(dbStudent);
		}
	}
	@Test
	public void test() {
		
	
	}

}
