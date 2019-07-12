package com.moneta.test.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.Pagination;
import com.moneta.test.domain.TestVO;

@Repository("com.moneta.test.DAO.ConnectDAO") // repository랑 resource랑 어떻게 다르지?
public class ConnectDAO extends PaxAbstractMapper{
	
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){// sqlSession: 정보를 담고 있고 다른 곳에서 접근 가능
	   super.setSqlSessionFactory(sqlSession);
    }
	
    //게시글 목록 가져오기 
	public List<TestVO> getList(TestVO vo){ //Resource로 가져온 SqlSeissionFactory의 sqlSession에 접근
		
		 return getSqlSession().selectList("com.moneta.test.mapper.newMapper.selectList",vo); // vo로 어떤 mapper의 sql명령을 쓰는 건지 알려줌
		 //mapper에서 설정한 "selectList" 사용
    }
	
	//상세보기 
	public TestVO getView(TestVO vo){ //Resource로 가져온 SqlSeissionFactory의 sqlSession에 접근
		
		 return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.selectView",vo.getBoardSeq()); // vo로 어떤 mapper의 sql명령을 쓰는 건지 알려줌
		 //mapper에서 설정한 "selectList" 사용
   }
	
	//게시글 삭제
	public int deleteSeq(TestVO vo) {
		return getSqlSession().delete("com.moneta.test.mapper.newMapper.deleteSeq", vo.getBoardSeq());
	}
	
	//게시글 수정
	public int editSeq(TestVO vo) {	
		return getSqlSession().update("com.moneta.test.mapper.newMapper.editSeq", vo);
	}
	
	//게시글 생성
	public int createContent(TestVO vo) {
		return getSqlSession().insert("com.moneta.test.mapper.newMapper.createSeq", vo);	
	}
	
	//총 게시글 수 받아오기
	public int getTotalcount(){ 
		
		 return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.countContent"); 
   }
	
	//페이징 처리된 게시글 목록 가져오기
	public List<TestVO> getTestList(Pagination pm) {
		
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.testlist", pm);
	}
	
	//페이징 처리된 검색 목록 가져오기
	public List<TestVO> getSearchList(Pagination pm) {
		
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.searchList", pm);
	}
	
	//상세보기 시 조회수 증가
	public int viewCntPlus(TestVO vo) {
		
		return getSqlSession().update("com.moneta.test.mapper.newMapper.viewCntPlus", vo);
	}

	//댓글 생성
	public int uploadCmt(CmtVO vo) {
		return getSqlSession().insert("com.moneta.test.mapper.newMapper.insertCmt", vo);
	}

	//댓글 목록 가져오기
	public List<CmtVO> getCmtList(CmtVO vo) {
		
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.readCmt", vo);
	}

	//댓글 수 가져오기
	public int getCmtTotalcount(CmtVO vo) {
		return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.cmtCount", vo); 
	}
	
	//검색 결과 수 가져오기
	public int getSearchCount(String searchWord) {
		return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.searchCount", searchWord); 
	}

}
