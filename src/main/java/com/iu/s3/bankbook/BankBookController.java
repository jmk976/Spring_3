package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.util.Pager_backup;

@Controller
@RequestMapping(value="/bankbook/**")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookUpdate")
	public void setUpdate(BankBookDTO bankBookDTO, Model model)throws Exception{
		
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value = "bankbookUpdate", method=RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO)throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		
		return "redirect:./bankbookList";
		
	}
	
	@RequestMapping("bankbookDelete")
	public String setDelete(BankBookDTO bankBookDTO)throws Exception {
		System.out.println("Delete!");
		System.out.println(bankBookDTO.getBooknumber());
		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
		
		return "redirect:./bankbookList";
	}

	@RequestMapping("bankbookList")  //속성 하나만 있을 경우  value 생략가능
	public ModelAndView getList(Pager_backup pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
	    System.out.println(pager.getCurPage());
		
		System.out.println("Service 호출전: "+pager.getTotalPage());
		
		List<BankBookDTO> ar = bankBookService.getList(pager);
		
		System.out.println("Service 호출: "+pager.getTotalPage());
	    System.out.println("서비스 호출후의 totalBlock: "+ pager.getTotalBlock());

		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping(value="bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv =new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		System.out.println("service");
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/bankbookSelect");
		return mv;
	}
}
