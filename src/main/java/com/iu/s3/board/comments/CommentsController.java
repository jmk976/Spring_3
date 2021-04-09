package com.iu.s3.board.comments;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/comments/**")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	//     / comments/commentsList
	
	@PostMapping("commentsInsert")
	public void setInsert(CommentsDTO commentsDTO )throws Exception{
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
	}
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO, Model model)throws Exception{
		System.out.println(commentsDTO.getNum());
	     List<CommentsDTO> ar =commentsService.getList(commentsDTO);
	     model.addAttribute("list", ar);
	}
	
	
	
	

}
