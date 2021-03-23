package com.iu.s3.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iu.s3.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest{

	private BankBookDAO bankBookDAO;
	
	@Test
	public void setWriteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookname("Test");
		bankBookDTO.setBookrate(0.12);
		bankBookDTO.setBooksale("Y");
		int result = bankBookDAO.setWrite(bankBookDTO);
		
		
		assertEquals(1,result);  // result가 1이면 좋겠다
	}
	

}
