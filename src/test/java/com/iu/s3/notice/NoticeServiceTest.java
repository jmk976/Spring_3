package com.iu.s3.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;
import com.iu.s3.board.notice.NoticeDTO;
import com.iu.s3.board.notice.NoticeService;

public class NoticeServiceTest extends MyAbstractTest {
	
	
	@Autowired
	private NoticeService noticeService;

	public void setHitUpdate(NoticeDTO noticeDTO)throws Exception{
		
		noticeDTO.setNum(2);
		int result = noticeService.setHitUpdate(noticeDTO);
		
		assertNotEquals(0, result);
		
	}

}
