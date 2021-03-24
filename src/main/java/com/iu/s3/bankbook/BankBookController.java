package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/**")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping("bankbookList")  //속성 하나만 있을 경우  value 생략가능
	public void getList(Model model)throws Exception{
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value="bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv =new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/bankbookSelect");
		return mv;
	}
}
