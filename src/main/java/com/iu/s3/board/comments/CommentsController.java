package com.iu.s3.board.comments;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/comments/**")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping("commentsDelete")
    public void commentsDelete(int [] commentNum) throws Exception{ //CommentsDTO배열로는 못받는다 타입이 안
		System.out.println("start");
    	
    	System.out.println("finish");
    }
	
	//     / comments/commentsList
	
	@PostMapping("commentsInsert")
	public ModelAndView setInsert(CommentsDTO commentsDTO )throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = commentsService.setInsert(commentsDTO);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO, Model model)throws Exception{
		System.out.println(commentsDTO.getNum());
	     List<CommentsDTO> ar =commentsService.getList(commentsDTO);
	     model.addAttribute("list", ar);
	}
	
	
	
	

}
