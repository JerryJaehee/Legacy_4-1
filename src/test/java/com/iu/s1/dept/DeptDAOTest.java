package com.iu.s1.dept;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class DeptDAOTest extends MyJunitTest {
	@Autowired
	private DeptDAO deptDAO;
	
	@Test
	public void listTest() throws Exception {
		List<DeptDTO> ar = deptDAO.list();
		
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).getDepartment_name());
		}
		
		assertNotEquals(0, ar.size());
		
	}
	



}
