package com.moneta.test.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.TestVO;

@Repository("com.moneta.test.DAO.ConnectDAO") // repository랑 resource랑 어떻게 다르지?
public class ConnectDAO extends PaxAbstractMapper{
	
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){// sqlSession: 정보를 담고 있고 다른 곳에서 접근 가능
	   super.setSqlSessionFactory(sqlSession);
    }
	
	
	public List<TestVO> getList(TestVO vo){ //Resource로 가져온 SqlSeissionFactory의 sqlSession에 접근
		
		 return getSqlSession().selectList("com.moneta.test.mapper.newMapper.selectList",vo); // vo로 어떤 mapper의 sql명령을 쓰는 건지 알려줌
		 //mapper에서 설정한 "selectList" 사용
    }

	public TestVO getView(TestVO vo){ //Resource로 가져온 SqlSeissionFactory의 sqlSession에 접근
		
		 return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.selectView",vo.getBoardSeq()); // vo로 어떤 mapper의 sql명령을 쓰는 건지 알려줌
		 //mapper에서 설정한 "selectList" 사용
   }
	public int deleteSeq(TestVO vo) {
		
		
		return getSqlSession().delete("com.moneta.test.mapper.newMapper.deleteSeq", vo.getBoardSeq());
	}
	
	public int editSeq(TestVO vo) {
		System.out.println("수정vo DAO->" + vo);
		
		return getSqlSession().update("com.moneta.test.mapper.newMapper.editSeq", vo);
	}
	
	public int createContent(TestVO vo) {
		System.out.println("글 생성 dao ->");
		return getSqlSession().insert("com.moneta.test.mapper.newMapper.createSeq", vo);
			
	}
	
	//게시글 목록 중 제일 마지막 board_seq 값을 받아오는 기능을 하는 메소드는 없나?
}
