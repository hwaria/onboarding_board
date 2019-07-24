package com.moneta.test.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.MemberVO;

@Repository("com.moneta.test.dao.MemgerRegDAO") 
public class MemgerRegDAO extends PaxAbstractMapper{
	//회원가입을 위한 dao
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){
	   super.setSqlSessionFactory(sqlSession);
    }
	
	//아이디 중복체크
	public int idCheck(String word) {
		int num = getSqlSession().selectOne("com.moneta.test.mapper.memberMapper.idCheck", word);
		return num;
	}
	//회원 가입
	public int memberRegistration(MemberVO vo) {
		int num =0;
		try {
			System.out.println("dao 옴");
			num = getSqlSession().insert("com.moneta.test.mapper.memberMapper.memberJoin", vo);
			System.out.println("dao 성공");}
		catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
}
