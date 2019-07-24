package com.moneta.test.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.MemberVO;

@Repository("com.moneta.test.dao.MemberDAO") 
public class MemberDAO extends PaxAbstractMapper{ // 로그인, 회원 관리위한 dao
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){
	   super.setSqlSessionFactory(sqlSession);
    }
	//로그인 위해 솔트값 가져오기
	public String getSaltById(MemberVO member) {
		String salt = getSqlSession().selectOne("com.moneta.test.mapper.memberMapper.getSalt", member);
		return salt;
	}
	//로그인 위해 비밀번호 확인
	public String checkPassword(MemberVO login) {
		
		return getSqlSession().selectOne("com.moneta.test.mapper.memberMapper.checkPassword", login);
	}
	//전체 회원 수 가져오기
	public int totalMembers() {
		int num = getSqlSession().selectOne("com.moneta.test.mapper.memberMapper.totalMembers");
		return num;
	}
}
