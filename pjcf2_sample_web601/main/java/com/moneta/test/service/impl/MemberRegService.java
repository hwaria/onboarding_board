package com.moneta.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.dao.MemgerRegDAO;
import com.moneta.test.domain.MemberVO;
import com.moneta.test.service.IMemberRegService;

@Service
public class MemberRegService implements IMemberRegService {
	@Resource
	private MemgerRegDAO memgerRegDAO;
	
	//아이디 중복 검사
	public int idCheck(String word) {
		return memgerRegDAO.idCheck(word);
	}
	//회원 가입 전 체크
	public int memberRegistration(MemberVO VO) {
		return memgerRegDAO.memberRegistration(VO); 
	}
}
