package com.iu.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping("noticeList")
	public void getList(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
	}

}
