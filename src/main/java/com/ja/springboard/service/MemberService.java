package com.ja.springboard.service;

import com.ja.springboard.vo.MemberVO;
import com.ja.springboard.vo.SessionUserData;

public interface MemberService {
	public void joinMember(MemberVO requestMemberVO);
	public SessionUserData login(MemberVO requestMemberVO);
	public boolean confirmID(MemberVO requestMemberVO);
}
