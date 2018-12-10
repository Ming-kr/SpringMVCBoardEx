package com.ja.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.springboard.service.MemberService;
import com.ja.springboard.vo.ConfirmData;
import com.ja.springboard.vo.MemberVO;

@RestController
public class MemberRESTfulController {
	
	@Autowired
	MemberService memberService; 
	
	@RequestMapping("/confirmID")
	public ConfirmData confirmID(MemberVO requestMemberVO) {
		ConfirmData confirmData = null;
		
		if(memberService.confirmID(requestMemberVO)) {
			confirmData = new ConfirmData(true);
		}else {
			confirmData = new ConfirmData(false);
		}
		return confirmData;
	}
}
