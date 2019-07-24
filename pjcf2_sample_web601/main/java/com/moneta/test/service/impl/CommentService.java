package com.moneta.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.domain.CmtVO;
import com.moneta.test.service.ICommentService;
import com.moneta.test.service.PagingService;

@Service
public class CommentService implements ICommentService {
	@Resource
	private com.moneta.test.dao.CommentDAO CommentDAO; //DAO와 연결
	
	//상세보기시 댓글이 있을 경우 댓글 가져오기
	public List<CmtVO> viewComment(CmtVO cVO) {
		return CommentDAO.viewComment(cVO);
	}
	//댓글 달기
	public int createComment(CmtVO cVO) {
		return CommentDAO.createComment(cVO);
	}
	//댓글 갯수 세기
	public int commentNum(CmtVO cVO) {
		return CommentDAO.commentNum(cVO);
	}
	//페이징 처리한 댓글 목록 가져오기
	public List<CmtVO> getSelectedCMT(PagingService pg) {
		List<CmtVO> selectCMT = new ArrayList<CmtVO>();
		selectCMT = CommentDAO.getSelectedCMT(pg);
		return selectCMT;
	}
}
