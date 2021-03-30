package com.iu.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iu.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int setHitUpdate(NoticeDTO noticeDTO) throws Exception {
		 return noticeDAO.setHitUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setDelete(noticeDTO);
	}
;	
	public int setUpdate(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception{
	      return noticeDAO.setInsert(noticeDTO);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		
		long h = noticeDTO.getHit();
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
		System.out.println(h);
		
		 return noticeDAO.getSelect(noticeDTO);
		
		 
	}
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		int perPage=10;//한페이지당 보여줄 글의 갯수
		int perBlock=5;// 한 블럭당 보여줄 숫자의 갯수
		
		
		// -------startRow, lastRow--------
		long startRow =(pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		//-------------------------------
		
	
		

		
		//-------------------------------
		//1. totalCount
		long totalCount=noticeDAO.getTotalCount(pager);
		
		//2. totalPage
		long totalPage= totalCount/perPage ;
		if(totalCount%perPage!=0) {
		     totalPage++;
		} 
		
		//3.totalBlock
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//4.curBlock
		long curBlock=pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5. startBlock ,lastBlock
		
		long startBlock = (curBlock-1)*perBlock+1;
		long lastBlock  = curBlock*perBlock;
		
		//6. curBlock이 마지막 block 일때 (totalBlock)
	     if(curBlock ==totalBlock) {
	    	 lastBlock =totalPage;
	     }
		
		//7. 이전, 다음 block 존재여부
		//이전
	     if(curBlock != 1) {
		   pager.setPre(true);
		   }
	    //다음
	     if(curBlock != totalBlock) {
	    	pager.setNext(true);
	    	}
		
		
	
		pager.setStartBlock(startBlock);
		pager.setLastBlock(lastBlock);
		
		System.out.println("curBlock: "+curBlock);
		System.out.println("TotalPage: " +totalPage);
		System.out.println("TotalBlock: "+totalBlock);
				
				
				
		return noticeDAO.getList(pager);
	}
	
	

}
