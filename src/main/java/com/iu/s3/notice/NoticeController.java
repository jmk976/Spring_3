package com.iu.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeUpdate")
	public void setUpdate()throws Exception{
		
	}
	
	@RequestMapping(value = "noticeUpdate", method=RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO, HttpSession session)throws Exception{
	  
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
		
		
		int result = noticeService.setUpdate(noticeDTO);
		
		if(result>0) {
			session.setAttribute("dto", noticeDTO);
			
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
		}
		
		return "redirect:./noticeList";
	}
	
	;
	@RequestMapping("noticeInsert")
	public void setInsert()throws Exception{
	}
	
	@RequestMapping(value="noticeInsert", method=RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setInsert(noticeDTO);
		System.out.println(result);
		return "redirect:./noticeList";
	}
	
	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		session.setAttribute("dto", noticeDTO);
	}
	
	@RequestMapping("noticeList")
	public void getList(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
	}

}
