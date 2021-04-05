package com.iu.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		mv.addObject("board", "qna");
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
	
		mv.setViewName("board/boardList");
	return mv;
	}
	
	@GetMapping("qnaInsert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");
		
		return mv;

	}
	@PostMapping("qnaInsert")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO);
		mv.setViewName("redirect:./qnaList");
		return mv;
	}

}
