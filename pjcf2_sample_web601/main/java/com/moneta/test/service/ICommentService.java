package com.moneta.test.service;

import java.util.List;

import com.moneta.test.domain.CmtVO;

public interface ICommentService {
	//상세보기시 댓글이 있을 경우 댓글 가져오기
	public List<CmtVO> viewComment(CmtVO cVO);
	//댓글 달기
	public int createComment(CmtVO cVO);
	//댓글 갯수 세기
	public int commentNum(CmtVO cVO);
	//페이징 처리한 댓글 목록 가져오기
	public List<CmtVO> getSelectedCMT(PagingService pg);
}
