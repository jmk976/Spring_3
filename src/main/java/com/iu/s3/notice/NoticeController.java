package com.iu.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("noticeHitUpdate")
	public void setHitUpdate(NoticeDTO noticeDTO)throws Exception{
		noticeService.setHitUpdate(noticeDTO);
		
	}
	
	@RequestMapping("noticeDelete")
	public String setDelete(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		System.out.println(result);
		return "redirect:./noticeList";
	}
	
	@RequestMapping("noticeUpdate")
	public void setUpdate()throws Exception{
		
	}
	
	@RequestMapping(value = "noticeUpdate", method=RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO, HttpSession session)throws Exception{

		
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
	public String setInsert(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.setInsert(noticeDTO);
		String message="글 작성 실패했습니다.";
	   
		if(result>0) {
			message="글 작성 성공했습니다";
		    
		}
		model.addAttribute("msg", message);
		model.addAttribute("root","./noticeList");
		return "common/commonResult";
	}
	
	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		session.setAttribute("dto", noticeDTO);
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		System.out.println("Service 호출전: "+pager.getTotalPage());
		List<NoticeDTO> ar = noticeService.getList(pager);
		System.out.println("Service 호출: "+pager.getTotalPage());
	    System.out.println("서비스 호출후의 totalBlock"+ pager.getTotalBlock());

		//List<NoticeDTO> ar = noticeService.getList(curPage);
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("notice/noticeList");
		modelAndView.addObject("pager",pager);
		return modelAndView;
	}

}
