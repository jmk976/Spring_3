package com.iu.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	@Autowired
    private AccountService accountService;
	
	@RequestMapping("accountAdd")
	public void setInsert()throws Exception{
		
	}
	
	@RequestMapping("accountList")
	public void getList() throws Exception {}
		
	
	@RequestMapping(value="accountList", method=RequestMethod.POST)
	public void getList(Model model,AccountDTO accountDTO) throws Exception {
		accountDTO.setId(accountDTO.getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list", ar);
		
		
	}
}
