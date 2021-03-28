package com.iu.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO.setTitle("test");
		noticeDTO.setContents("test");
		
		
		 int result = noticeDAO.setUpdate(noticeDTO);
		 
		 assertEquals(1, result);
	}
	
	//@Test
	public void getListTest() throws Exception{
		List<NoticeDTO> ar = noticeDAO.getList();
		
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
		 
	}
	
	
	

}
