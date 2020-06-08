package com.gui.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

//import org.junit.Test;

import com.gui.dao.StudentDao;
import com.gui.model.Student;
import com.gui.util.JdbcUtil;

public class TestAll {
	
	private static StudentDao sDao=new StudentDao();
	
//	@Test
	public void test1() {
		System.out.println(JdbcUtil.getConnection());
	}
	
//	@Test
	public void testAdd() {
		Student s=new Student("合理", 99, LocalDate.now(), "成都");
		try {
			sDao.add(s);
			System.out.println("成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("失败");
		}
	}
	
//	@Test
	public void testUpdate() throws SQLException {
		Student s=new Student(1,"河田",99,LocalDate.of(1999, 2, 28),"未来世界");
		sDao.update(s);
	}
	
//	@Test
	public void testCreate() throws SQLException {
		List<Student> queryAll = sDao.queryAll();
		System.out.println(queryAll);
	}
	
//	@Test
	public void testRemove() {
		int id=1;
		try {
			sDao.detele(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
