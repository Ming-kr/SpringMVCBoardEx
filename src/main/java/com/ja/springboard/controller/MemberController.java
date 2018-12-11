package com.ja.springboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.springboard.service.MemberService;
import com.ja.springboard.vo.MemberVO;
import com.ja.springboard.vo.SessionUserData;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	//생성자 주입
	/*
	@Autowired 
	public MemberController(MemberService memberService) { 
		this.memberService = memberService; 
	}
	*/
	
	//단순 맵핑 메소드
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "/loginForm";
	}
	
	@RequestMapping("/joinMemberForm")
	public String joinMemberForm() {
		return "/joinMemberForm";
	}
	
	//로직 처리 메소드
	@RequestMapping("/joinMemberFormAction")
	public String joinMemberFormAction(Model model , MemberVO requestMemberVO) {
		
		//서비스 객체에서 회원가입 메소드 호출
		memberService.joinMember(requestMemberVO);
		return "/completeJoinMember";
	}
	
	@RequestMapping("/loginFormAction")
	public String loginFormAction(Model model , HttpSession session , MemberVO requestMemberVO) {
		
		SessionUserData sessionUserData = memberService.login(requestMemberVO);
		
		if(sessionUserData == null) {
			return "/loginFail";
		}
		
		session.setAttribute("sessionUserData", sessionUserData);		
		return "redirect:/board";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/board";
	}
}












