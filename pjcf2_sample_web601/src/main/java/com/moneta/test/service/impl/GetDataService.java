package com.moneta.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.dao.GetDataDAO;
import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.IGetDataService;
import com.moneta.test.service.PagingService;


@Service
public class GetDataService implements IGetDataService {
	
	@Resource
	private GetDataDAO getDataDAO; //DAO와 연결
	
	//전체 게시글 목록 가져오기
	public List<TestVO> getBoardList() {
		List<TestVO> boardList = new ArrayList <TestVO>();
		TestVO vo = new TestVO();
		boardList = getDataDAO.getBoard(vo);
		return boardList;
	}
	//상세보기
	public TestVO viewContent(TestVO vo) {
		return getDataDAO.viewContent(vo);
	}
	//게시글 삭제
	public int deleteContent(TestVO vo) {
		return getDataDAO.deleteContent(vo);
	}
	//게시글 생성
	public int createContent(TestVO vo) {
		return getDataDAO.createContent(vo);
	}
	//게시글 수정
	public int updateContent(TestVO vo) {
		return getDataDAO.updateContent(vo);
	}
	//게시글 수 가져오기
	public int contentsNum() {
		return getDataDAO.contentsNum();
	}
	//페이징 처리한 게시글 목록 가져오기
	public List<TestVO> getSelectedBoard(PagingService pg) {
		List<TestVO> selectedList = new ArrayList <TestVO>();
		selectedList = getDataDAO.getSelectedBoard(pg);
		return selectedList;
	}
	//상세보기 시 조회수 1 증가
	public int updateViewCnt(TestVO vo) {
		
		return getDataDAO.updateViewCnt(vo);
	}
	//상세보기시 댓글이 있을 경우 댓글 가져오기
	public List<CmtVO> viewComment(CmtVO cVO) {
		return getDataDAO.viewComment(cVO);
	}
	//댓글 달기
	public int createComment(CmtVO cVO) {
		return getDataDAO.createComment(cVO);
	}
	//댓글 갯수 세기
	public int commentNum(CmtVO cVO) {
		return getDataDAO.commentNum(cVO);
	}
	//페이징 처리한 댓글 목록 가져오기
	public List<CmtVO> getSelectedCMT(PagingService pg) {
		List<CmtVO> selectCMT = new ArrayList<CmtVO>();
		selectCMT = getDataDAO.getSelectedCMT(pg);
		return selectCMT;
	}
	//검색 결과 목록 가져오기
	public List<TestVO> searchResult(PagingService pg){
		List<TestVO> search = new ArrayList<TestVO>();
		search = getDataDAO.searchResult(pg); 
		return search;
	}
	//검색 결과 게시글 수 가져오기
	public int searchResNum(String word) {
		return getDataDAO.searchResNum(word);
	}
	//첨부 파일 삭제하기
	public int deleteFile(TestVO vo) { 
		return getDataDAO.deleteFile(vo);
	}
	//추천수 증가
	public int rcmUpdate(TestVO vo) {
		return getDataDAO.rcmUpdate(vo);
	}
}
