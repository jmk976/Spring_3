package com.iu.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int setReply(QnaDTO qnaDTO)throws Exception {
		//부모글의 step, depth, ref 조회
	BoardDTO boardDTO = qnaDAO.getSelect(qnaDTO);
	QnaDTO parent = (QnaDTO)boardDTO;
	System.out.println(parent.getRef());
    System.out.println(parent.getStep());	
    System.out.println(parent.getDepth());
    
    qnaDTO.setRef(parent.getRef());
    qnaDTO.setStep(parent.getStep()+1);
    qnaDTO.setDepth(parent.getDepth()+1);


    int result = qnaDAO.setReplyUpdate(parent);
    result = qnaDAO.setReply(qnaDTO);
    
    return result;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
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
		long totalCount=qnaDAO.getTotalCount(pager);
		
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
				
				
		
		
		return qnaDAO.getList(pager);
	}

	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setInsert(boardDTO);
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

	
	
	

}
