package com.moneta.test.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.PagingService;
import com.moneta.test.service.impl.CommentService;
import com.moneta.test.service.impl.GetDataService;

@Controller
public class ViewController {
	@Resource // 게시글 변수가 담겨있는 클래스
	TestVO TestVO;
	@Resource // 게시글 변수가 담겨있는 클래스
	CmtVO cVO;
	@Resource
	CommentService cmtService;
	@Resource
	GetDataService getData;
	@Resource
	PagingService paging;
	
	// 상세보기 & 댓글 보여주기
	@RequestMapping("/view")
	public String viewComment(@RequestParam(value = "cmtPage", defaultValue = "1") int cmtPage, TestVO vo, CmtVO cVO,
			Model model) {
		
		try {
			// get방식으로 게시글 넘버 가져와서 VO에 담아 DB에 boardSeq넘겨줌
			TestVO content = new TestVO();
			content = getData.viewContent(vo);
			
			// 상세보기 페이지에 게시글 내용 보내줌
			model.addAttribute("content", content);
			// 상세보기시 조회수 증가
			int updatedViewCnt = getData.updateViewCnt(vo);
			
			// 해당 게시물에 댓글이 있을 경우 댓글 보여주기- cmtView.jsp
			// 댓글 클래스 객체 생성 후 클릭한 게시글의 넘버 넣어서 db에 보냄

			cVO.setBoardSeq(vo.getBoardSeq());

			// 해당 게시물 댓글 갯수 세오기
			int commentsNum = cmtService.commentNum(cVO);

			// 페이징 처리해주는 클래스 객체 생성해서 총 댓글 갯수, 게시물 넘버 주입
			PagingService cmtPaging = new PagingService();
			cmtPaging.setContentsNum(commentsNum);
			cmtPaging.setCurPage(cmtPage);
			cmtPaging.setBoardSeq(cVO.getBoardSeq());

			// 댓글 페이지 정보를 가지고 있는 객체를 쿼리에 보내서 목록가져오기
			List<CmtVO> cmtList = new ArrayList<CmtVO>();
			cmtList = cmtService.getSelectedCMT(cmtPaging);
//						System.out.println("댓글 페이징 성공");

			model.addAttribute("cmtList", cmtList);
			model.addAttribute("cmtPaging", cmtPaging);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "test/viewContent";
	}
}
