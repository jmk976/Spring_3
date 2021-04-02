package com.iu.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	

	
	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
		
	}
	
	
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setInsert(boardDTO);
	}



	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	



	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	public List<BoardDTO> getList(Pager pager) throws Exception{
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
