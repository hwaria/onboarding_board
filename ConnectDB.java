package com.moneta.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.domain.Pagination;
import com.moneta.test.DAO.ConnectDAO;
import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.IconnectDB;


@Service
public class ConnectDB implements IconnectDB{

//	@Resource 
//	private PageMaker pagemaker;
	
	@Resource
	private ConnectDAO connectDAO;
	
	public List<TestVO> getList() { 
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		list =  connectDAO.getList(vo); 
		// testVO (sql에서 가져온 데이터에서 각각의 정보에 접근 가능)를  파라미터로 ConnectDao에 던져줌 
		return list;
	}
	
	public List<TestVO> getTestList(Pagination pm) { 
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		list =  connectDAO.getTestList(pm); 
		
		return list;
	}
	
	public List<TestVO> getSearchList(Pagination pm) { 
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		list =  connectDAO.getSearchList(pm); 
		
		return list;
	}
	
	public TestVO getView(TestVO vo) {
		TestVO resVO = connectDAO.getView(vo);
		return resVO;
		
	}
	
	public int deleteSeq(TestVO vo) {
		
		int deletedRow = connectDAO.deleteSeq(vo);
		return deletedRow;
	}

	public int editSeq(TestVO vo) {
		System.out.println("수정vo connectDB->");
		int editedRow = connectDAO.editSeq(vo);
		return editedRow;
	}

	public int createContent(TestVO vo) {
		
		int newCont = connectDAO.createContent(vo);
		return newCont;
	}
	
	
	public int getTotalcount() {
		
		int totalcount = connectDAO.getTotalcount();
		return totalcount;
	}
	
	public int viewCntPlus(TestVO vo) {
		int affectedRow = connectDAO.viewCntPlus(vo);
		return affectedRow;
	}
	
	public int uploadCmt(CmtVO vo) {
		
		int resCmt = connectDAO.uploadCmt(vo);
		System.out.println("connectDB코멘트 sql 잘 들어감");
		return resCmt;
	}

	public List<CmtVO> getCmtList(CmtVO VO) {
		List<CmtVO> cmtList = new ArrayList<CmtVO>();
		System.out.println("??>>");
		cmtList = connectDAO.getCmtList(VO); 
		
		return cmtList;
	}

	public int getCmtTotalcount(CmtVO vo) {

		int cmtTotalcount = connectDAO.getCmtTotalcount(vo);
		return cmtTotalcount;
	}
	
	public int getSearchCount(String searchWord) {

		int searchCount = connectDAO.getSearchCount(searchWord);
		return searchCount;
	}
	
	
}
