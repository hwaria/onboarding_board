package com.moneta.test.service;

import com.moneta.test.domain.MemberVO;

public interface IMemberRegService {
	//아이디 중복 검사
	public int idCheck(String word);
	//회원 가입 전 체크
	public int memberRegistration(MemberVO VO);	
}
