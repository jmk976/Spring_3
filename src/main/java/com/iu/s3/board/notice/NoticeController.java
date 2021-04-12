package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backup;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files)throws Exception{

		int result= noticeService.setUpdate(boardDTO);
		
		//성공하면 리스트로 이동
		if(result>0) {
		   mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", "수정실패");
		    mv.addObject("root", "./noticeList");
		    mv.setViewName("common/commonResult");
		}
		//실패하면 수정실패 띄우고, 리스트로 이동
		
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	
		

	
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv= new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		
		String message="삭제 실패";
		String root = "./noticeList";
		
		if(result>0) {
			message="삭제 성공";
			
		}
		
		mv.addObject("msg",message);
		mv.addObject("root",root);
		
		mv.setViewName("common/commonResult");
		
		return mv;
		
	}
	
	
	@RequestMapping("noticeHitUpdate")
	public void setHitUpdate(NoticeDTO noticeDTO)throws Exception{
		noticeService.setHitUpdate(noticeDTO);
		
	}
	

	
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv =new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		
		return mv;

	}
	
	@RequestMapping(value="noticeInsert", method=RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files)throws Exception{
		System.out.println("Insert start");
		for(MultipartFile mf: files) {
			System.out.println(mf.getOriginalFilename());
		}
		System.out.println("Insert finish");
		//int result = noticeService.setInsert(boardDTO);
		
	    int result = noticeService.setInsert(boardDTO, files);
		String message="글 등록 실패.";
	   
		if(result>0) {
			message="글 등록 성공";
		    
		}
		model.addAttribute("msg", message);
		model.addAttribute("root","./noticeList");
		return "common/commonResult";
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		System.out.println("Service 호출전: "+pager.getTotalPage());
		List<BoardDTO> ar = noticeService.getList(pager);
		System.out.println("Service 호출: "+pager.getTotalPage());


		//List<NoticeDTO> ar = noticeService.getList(curPage);
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("board/boardList");
		modelAndView.addObject("board", "notice");
		modelAndView.addObject("pager",pager);
		return modelAndView;
	}

}
