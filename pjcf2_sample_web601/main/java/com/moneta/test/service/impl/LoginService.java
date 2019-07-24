package com.moneta.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.dao.MemberDAO;
import com.moneta.test.domain.MemberVO;

@Service
public class LoginService {
	@Resource
	MemberRegService memberReg;
	@Resource
	private MemberDAO memberDAO;
	
	//로그인 위해 솔트값 가져오기
	public String getSaltById(MemberVO member) {
		return memberDAO.getSaltById(member);
	}
	
	//비밀번호 일치 여부 확인
	public String checkPassword(MemberVO login) {
		return memberDAO.checkPassword(login);
	}
	
	
}
