package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.FileManager;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backup;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
    private HttpSession session;
	
	
    
	
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
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
	    long num  = noticeDAO.getNum();
	    
	    boardDTO.setNum(num);
		
		
		int result =noticeDAO.setInsert(boardDTO);
		
		//글번호 찾기
	
		
		for(MultipartFile mf: files) {
			  BoardFileDTO boardFileDTO = new BoardFileDTO(); 
			  String fileName = fileManager.save("notice", mf, session);
			  
			  boardFileDTO.setNum(num);
			  boardFileDTO.setFileName(fileName);
			  boardFileDTO.setOriginName(mf.getOriginalFilename());
			  
			  noticeDAO.setFileInsert(boardFileDTO);
		  }
		return result; //noticeDAO.setInsert(boardDTO);
	}



	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	



	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}



	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}



	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		
		// -------startRow, lastRow--------
		pager.makeRow();
	
		//-------------------------------
		
		//-----------페이징계산  ---------
		long totalCount= noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
				
		
		return noticeDAO.getList(pager);
	}
	
	

}
