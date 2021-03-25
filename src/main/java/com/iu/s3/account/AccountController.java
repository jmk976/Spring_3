package com.iu.s3.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/account/**")
public class AccountController {
	
	@Autowired
    private AccountService accountService;
	
	@RequestMapping("accountList")
	public void getList() throws Exception {}
		
	
	@RequestMapping(value="accountList", method=RequestMethod.POST)
	public void getList(ModelAndView modelAndView,AccountDTO accountDTO) throws Exception {
		
		List<AccountDTO> ar = accountService.getList(accountDTO);
		modelAndView.addObject("list", ar);
		
	}
}
