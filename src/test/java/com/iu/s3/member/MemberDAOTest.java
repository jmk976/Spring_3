package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void memberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id13");
		memberDTO.setPw("pw13");
		memberDTO.setName("id13");
		memberDTO.setPhone("010-1111-1313");
		memberDTO.setEmail("id13@naver.com");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void memberLoginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("pw1");
		
		assertNotNull(memberDTO);
		
	}

}
