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
	
	@Test 
	public void setInserTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		for(int i=0;i<120;i++) {
		noticeDTO.setTitle("test title"+i);
		noticeDTO.setContents("test contents"+i);
		int result = noticeDAO.setInsert(noticeDTO);
		if(i%10==0) {
		Thread.sleep(500);
		}
		}
	}
	
	
	
	
	

}
