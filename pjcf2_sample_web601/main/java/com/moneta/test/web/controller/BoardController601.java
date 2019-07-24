package com.moneta.test.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.moneta.test.domain.TestVO;
import com.moneta.test.service.PagingService;
import com.moneta.test.service.impl.GetDataService;
import com.moneta.test.service.impl.MemberRegService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController601 {

	@Resource // 게시글 변수가 담겨있는 클래스
	TestVO TestVO;

	@Resource
	GetDataService getData;
	
	@Resource
	MemberRegService memberReg;

	@Resource
	PagingService paging;

	// 게시판 보여주기
	@RequestMapping("/main6")
	public String getBoard(@RequestParam(value = "page", defaultValue = "1") int page, String search, Model model) {
		System.out.println("/main6 게시글목록");

		// 검색을 하지 않았을 경우
		if ("".equals(search) || search == null) {
			try {
				// 게시글 목록의 타입 알려주기
				String original = "original";

				// 총 게시글 수 가져오기
				int contsNum = getData.contentsNum();
				// 페이징 처리를 해주는 클래스의 객체 생성 후 총 게시글 수, 현재 페이지 넣어주기
				PagingService paging = new PagingService();
				paging.setContentsNum(contsNum);
				paging.setCurPage(page); // 현재 페이지 설정해주기

				// 페이징 처리한 목록 가져오기
				List<TestVO> selectedList = new ArrayList<TestVO>();
				selectedList = getData.getSelectedBoard(paging);

				// 메인 페이지에 페이징 처리된 게시글 목록 넘겨주기
				model.addAttribute("boardList", selectedList);
				model.addAttribute("paging", paging);
				model.addAttribute("listType", original);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // 검색어 search가 빈 값이 아니면 검색해어 결과 화면에 돌려주기
			try {
				// 게시글 목록의 타입 알려주기
				String searches = "searches";

//				System.out.println("ctr" + search);
				// 검색 결과 게시물 수 가져오기
				int searchRes = getData.searchResNum(search);

				// 페이징 처리해서 검색 결과 목록 가져오기
				PagingService paging = new PagingService();
				paging.setContentsNum(searchRes);
				paging.setCurPage(page);
				paging.setSearchWord(search);

				List<TestVO> selectedList = new ArrayList<TestVO>();
				selectedList = getData.searchResult(paging);

				// 메인 페이지에 페이징 처리된 게시글 목록 넘겨주기
				model.addAttribute("boardList", selectedList);
				model.addAttribute("paging", paging);
				model.addAttribute("listType", searches);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*
		 * 전체 게시글 목록 가져오기 //게시글 목록 가져와서 리스트에 담기 List <TestVO> boardList = new
		 * ArrayList<TestVO>(); boardList = getData.getBoardList();
		 * 
		 * //메인 페이지 index.jsp에 목록 넘겨주기 model.addAttribute("boardList", boardList);
		 * 
		 */
		return "/test/index"; // 메인페이지
	}

	// 삭제 기능
	@RequestMapping("/delete")
	public String deleteContent(TestVO vo, Model model) {
//		System.out.println("/delete 삭제 하기");
//		System.out.println("삭제할 게시글 " + vo.getBoardSeq());
		// 게시글 넘버 DB에 보내주기, 삭제 처리
		int deletedRowNum = getData.deleteContent(vo);
		System.out.println("삭제 성공" + deletedRowNum);
		model.addAttribute("deletedRowNum", deletedRowNum);

		return "/test/result";
	}

	// 글 수정, method는 post로만 받도록 함
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editContent(TestVO vo) {
		// 수정내용 db에 보내기
		int updatedRowNum = getData.updateContent(vo);
		System.out.println("수정성공" + updatedRowNum);
		return "redirect: ../main6";
	}
//

	// 첨부파일 삭제 기능
	@RequestMapping("/deleteFile")
	public String deleteFile(TestVO vo, Model model) {
//		System.out.println("파일 삭제할 게시물 넘버 " + vo.getBoardSeq());
		int deleted = getData.deleteFile(vo);
//		System.out.println("삭제 성공");
		return "redirect: ../view?boardSeq=" + vo.getBoardSeq();
	}
	
	// 추천수 증가 기능
	@RequestMapping("/rcm")
	public String rcmUpdate(TestVO vo, Model model) {
		try {
//			System.out.println("추천할 게시글 넘버 " + vo.getBoardSeq());
			int rcm = getData.rcmUpdate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: ../view?boardSeq=" + vo.getBoardSeq();
	}


}
