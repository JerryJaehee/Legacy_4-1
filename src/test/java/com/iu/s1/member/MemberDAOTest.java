package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void mypageTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3sdfsfs");
		memberDTO = memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void loginTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO.setPw("pw3234234");
		
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
		
	}
	
	//@Test
	public void joinTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setPhone("010-1111-1111");
		memberDTO.setEmail("ide2@gmail.com");
		int result = memberDAO.join(memberDTO);
		assertEquals(1, result);
		
	}

}
