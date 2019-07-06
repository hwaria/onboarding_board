package com.moneta.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.moneta.test.DAO.ConnectDAO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.IconnectDB;


@Service
public class ConnectDB implements IconnectDB{

	@Resource
	private ConnectDAO connectDAO;
	
	public List<TestVO> getList() { 
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		list =  connectDAO.getList(vo); 
		// testVO (sql에서 가져온 데이터에서 각각의 정보에 접근 가능)를  파라미터로 ConnectDao에 던져줌 
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
	
//	public int getLastSeqNum() {
//		int lastNum = connectDAO.getLastSeq();
//		return lastNum;
//	}
	
}
