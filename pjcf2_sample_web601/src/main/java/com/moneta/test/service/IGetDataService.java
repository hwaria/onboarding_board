package com.moneta.test.service;

import java.util.List;

import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.TestVO;

public interface IGetDataService {
	//게시글 전체 목록
	public List <TestVO> getBoardList();
	//상세보기
	public TestVO viewContent(TestVO vo);
	//삭제
	public int deleteContent(TestVO vo);
	//글 생성
	public int createContent(TestVO vo);
	//글 수정
	public int updateContent(TestVO vo);
	//조회수 올리기
	public int updateViewCnt(TestVO vo);
	//총 게시글 수 구하기
	public int contentsNum();
	//게시글 페이징
	public List<TestVO> getSelectedBoard(PagingService pg);
	//첨부 파일 삭제하기
	public int deleteFile(TestVO vo);
	//검색 결과 게시글 수 가져오기
	public int searchResNum(String word);
	//검색 기능 
	public List<TestVO> searchResult(PagingService pg);
	//댓글 달기
	public int createComment(CmtVO cVO);
	//댓글 갯수 세기
	public int commentNum(CmtVO cVO);
	//페이징처리한 댓글 목록 가져오기
	public List<CmtVO> getSelectedCMT(PagingService pg);	
	//추천수 증가
	public int rcmUpdate(TestVO vo);
}
