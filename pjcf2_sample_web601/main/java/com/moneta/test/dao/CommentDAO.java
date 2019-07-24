package com.moneta.test.dao;


import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.moneta.framework.pjcf.dao.PaxAbstractMapper;
import com.moneta.test.domain.CmtVO;
import com.moneta.test.service.PagingService;

//댓글 crud, paging 
@Repository("com.moneta.test.dao.CommentDAO") 
public class CommentDAO extends PaxAbstractMapper {
	
	@Resource(name="SqlSessionFactory") 
    public void setSqlSessionFactory(SqlSessionFactory sqlSession){// sqlSession: 정보를 담고 있고 다른 곳에서 접근 가능
	   super.setSqlSessionFactory(sqlSession);
    }
	
	//상세보기시 댓글이 있을 경우 댓글 가져오기
	public List<CmtVO> viewComment(CmtVO cVO) {	
		return getSqlSession().selectList("com.moneta.test.mapper.commentMapper.viewComment", cVO);
	}
	
	//댓글 달기 
	public int createComment(CmtVO cVO) {
		int createdCMT = getSqlSession().insert("com.moneta.test.mapper.commentMapper.createComment", cVO);	
		return createdCMT;
	}
	
	//해당 게시글 댓글 수 세기
	public int commentNum(CmtVO cVO) {
		int cNum = getSqlSession().selectOne("com.moneta.test.mapper.commentMapper.commentNum", cVO);
		return cNum;
	}
	
	//페이징 처리한 댓글 목록 가져오기
	public List<CmtVO> getSelectedCMT(PagingService pg) {		
		return getSqlSession().selectList("com.moneta.test.mapper.commentMapper.selectCmtList", pg);
	}
	
}
