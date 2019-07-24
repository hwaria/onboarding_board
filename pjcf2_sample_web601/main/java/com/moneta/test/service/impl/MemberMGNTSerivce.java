package com.moneta.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.dao.GetDataDAO;
import com.moneta.test.dao.MemberDAO;
import com.moneta.test.service.IMemberMGNTService;

@Service
public class MemberMGNTSerivce implements IMemberMGNTService {
	@Resource
	private MemberDAO memberDAO;
	
	//회원 수 세기 
	public int totalMembers() { 
		return memberDAO.totalMembers(); 
	}
}
