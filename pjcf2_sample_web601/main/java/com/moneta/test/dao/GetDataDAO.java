package com.moneta.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.PagingService;

@Repository("com.moneta.test.dao.GetDataDAO") 
public class GetDataDAO extends PaxAbstractMapper{
	
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){// sqlSession: 정보를 담고 있고 다른 곳에서 접근 가능
	   super.setSqlSessionFactory(sqlSession);
    }
	
	//전체 게시판 목록 가져오기
	public List<TestVO> getBoard(TestVO vo) {
		//mapper에서 어떤 쿼리를 쓸지 id를 알려주고 파라미터로 vo를 넘김
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.selectBoardList", vo); 
	}
	
	//게시물 제목 클릭시 상세보기
	public TestVO viewContent(TestVO vo) {
		
		return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.viewContent", vo);
	}
	
	//삽입, 삭제, 갱신 리턴 타입은 int
	public int deleteContent(TestVO vo) {
		int deleted = getSqlSession().delete("com.moneta.test.mapper.newMapper.deleteContent", vo.getBoardSeq());
		
		return deleted;
	}
	
	//게시물 생성
	public int createContent(TestVO vo) {
		int created = getSqlSession().insert("com.moneta.test.mapper.newMapper.createContent", vo);
		
		return created;
	}
	
	//게시물 수정
	public int updateContent(TestVO vo) {
		int updated = getSqlSession().update("com.moneta.test.mapper.newMapper.updateContent", vo);
		System.out.println("dao 수정성공" + updated);
		return updated;
	}
	
	//총 게시글 수 
	public int contentsNum() {
		int num = getSqlSession().selectOne("com.moneta.test.mapper.newMapper.contentsNum");
		/* System.out.println("dao 총 게시글 수" + num); */
		return num;
	}
	
	//페이징 처리해서 게시글 목록 가져오기
	public List<TestVO> getSelectedBoard(PagingService pg) {
		
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.getSeletedList", pg); 
	}
	
	//상세보기 시 조회수 1 증가
	public int updateViewCnt(TestVO vo) {
		int ViewCnt = getSqlSession().update("com.moneta.test.mapper.newMapper.updateViewCnt", vo); 
		return ViewCnt;
	}
	
	//검색 결과 게시글 수 가져오기
	public int searchResNum(String word) {
		System.out.println("getdataDAO word" + word);
		return getSqlSession().selectOne("com.moneta.test.mapper.newMapper.searchResNum", word);
	}
	//검색 결과 페이징 목록 가져오기
	public List<TestVO> searchResult(PagingService pg) {
		
		return getSqlSession().selectList("com.moneta.test.mapper.newMapper.searchResult", pg);
	}
	//첨부 파일 삭제하기
	public int deleteFile(TestVO vo) {
		int deleted = getSqlSession().update("com.moneta.test.mapper.newMapper.deleteFile", vo); 
		return deleted;
	}
	
	//추천수 증가
	public int rcmUpdate(TestVO vo) {
		int rcmUpdated = getSqlSession().update("com.moneta.test.mapper.newMapper.rcmUpdate", vo); 
		return rcmUpdated;
	}

	
}
