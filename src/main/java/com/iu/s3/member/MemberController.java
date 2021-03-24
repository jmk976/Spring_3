package com.iu.s3.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberLogin")
	public void memberLogin() throws Exception {
	
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);
		session.setAttribute("member", memberDTO);
		
		return "redirect:../";
	}
	
	@RequestMapping(value="memberJoin")
	public void memberJoin() throws Exception {
	}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception {
		
		int result =memberService.memberJoin(memberDTO);
		
		return "redirect:../";
	}

}
