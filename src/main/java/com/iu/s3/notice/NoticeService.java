package com.iu.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception{
	      return noticeDAO.setInsert(noticeDTO);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		 return noticeDAO.getSelect(noticeDTO);
	}
	
	public List<NoticeDTO> getList() throws Exception{
		return noticeDAO.getList();
	}
	
	

}
