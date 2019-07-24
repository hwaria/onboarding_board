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
public class CommentController {
		@Resource // 게시글 변수가 담겨있는 클래스
		TestVO TestVO;
	
		@Resource
		CommentService cmtService;
	
		@Resource
		GetDataService getData;
		
		@Resource
		PagingService paging;
		
		// 댓글 달기 기능
		@RequestMapping("/postCmt")
		public String postComment(TestVO vo, CmtVO cVO, Model model) {
			try {
				// 댓글 객체에 게시글 넘버 넣어준후 쿼리
				cVO.setBoardSeq(vo.getBoardSeq());
				int createdCMT = cmtService.createComment(cVO);
				
				// 댓글 추가 후 다시 해당 게시글 내용 가져오기
				TestVO content = new TestVO();
				content = getData.viewContent(vo);

				// 댓글 추가 후 추가된 댓글을 포함한 새 게시글의 댓글 목록 가져오기
				CmtVO addVO = new CmtVO();
				addVO.setBoardSeq(vo.getBoardSeq());
				List<CmtVO> newCmtList = new ArrayList<CmtVO>();
				newCmtList = cmtService.viewComment(cVO);
				
				// 상세보기 페이지에 게시글 내용 & 댓글 내용 보내줌
				model.addAttribute("cmtList", newCmtList);
				model.addAttribute("content", content);	
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return "test/viewContent";
		}
		
			
		
}		
