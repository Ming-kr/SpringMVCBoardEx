package com.ja.springboard.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.springboard.mapper.MemberSQLMapper;
import com.ja.springboard.vo.MemberVO;
import com.ja.springboard.vo.SessionUserData;

@Service
public class MemberServiceImpl implements MemberService {

	//DAO 객체 주입...
	@Autowired
	MemberSQLMapper memberSQLMapper; 
	
	
	@Override
	public void joinMember(MemberVO requestMemberVO) {
		// TODO Auto-generated method stub
		String digestValue = 
				DigestUtils.sha256Hex(requestMemberVO.getM_pw());
		
		requestMemberVO.setM_pw(digestValue);
		
		memberSQLMapper.insert(requestMemberVO);
	}


	@Override
	public SessionUserData login(MemberVO requestMemberVO) {
		// TODO Auto-generated method stub
		
		String digestValue = 
				DigestUtils.sha256Hex(requestMemberVO.getM_pw());
		requestMemberVO.setM_pw(digestValue);
		
		
		MemberVO dbMemberVO = memberSQLMapper.selectById(requestMemberVO);	
		
		if(dbMemberVO != null && requestMemberVO.getM_pw().equals(dbMemberVO.getM_pw())) {
			return new SessionUserData(dbMemberVO.getM_idx(), dbMemberVO.getM_nick());
		}
		
		return null;
	}


	@Override
	public boolean confirmID(MemberVO requestMemberVO) {
		// TODO Auto-generated method stub
		
		MemberVO memberVO = 
				memberSQLMapper.selectById(requestMemberVO);
		
		if(memberVO != null)
			return true;
		
		return false;
	}
	
	
	
}





