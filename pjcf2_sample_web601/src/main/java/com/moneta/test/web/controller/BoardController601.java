package com.moneta.test.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.moneta.test.domain.CmtVO;
import com.moneta.test.domain.FileVO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.PagingService;
import com.moneta.test.service.impl.GetDataService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController601 {

	@Resource // 게시글 변수가 담겨있는 클래스
	TestVO TestVO;

	@Resource
	GetDataService getData;

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

	// 상세 보기 기능
	@RequestMapping("/view")
	public String viewContent(@RequestParam(value = "cmtPage", defaultValue = "1") int cmtPage, TestVO vo, CmtVO cVO,
			Model model) {

		try {
			System.out.println("/view 상세 보기");
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
			int commentsNum = getData.commentNum(cVO);
//			System.out.println("글넘버" + cVO.getBoardSeq() + "댓글 수 " + commentsNum);
//			System.out.println("현재 댓글 페이지" + cmtPage);

			// 페이징 처리해주는 클래스 객체 생성해서 총 댓글 갯수, 게시물 넘버 주입
			PagingService cmtPaging = new PagingService();
			cmtPaging.setContentsNum(commentsNum);
			cmtPaging.setCurPage(cmtPage);
			cmtPaging.setBoardSeq(cVO.getBoardSeq());

			// 댓글 페이지 정보를 가지고 있는 객체를 쿼리에 보내서 목록가져오기
			List<CmtVO> cmtList = new ArrayList<CmtVO>();
			cmtList = getData.getSelectedCMT(cmtPaging);
			System.out.println("댓글 페이징 성공");

			model.addAttribute("cmtList", cmtList);
			model.addAttribute("cmtPaging", cmtPaging);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/test/viewContent";
	}

	// 삭제 기능
	@RequestMapping("/delete")
	public String deleteContent(TestVO vo, Model model) {
		System.out.println("/delete 삭제 하기");
		System.out.println("삭제할 게시글 " + vo.getBoardSeq());
		// 게시글 넘버 DB에 보내주기, 삭제 처리
		int deletedRowNum = getData.deleteContent(vo);
		System.out.println("삭제 성공" + deletedRowNum);
		model.addAttribute("deletedRowNum", deletedRowNum);

		return "/test/result";
	}

	// 글 작성 폼 보여주기
	@RequestMapping("/write")
	public String writeContent(String mode, TestVO vo, Model model) {
		// 글 생성/수정 버튼을 누를 경우 글 작성 폼을 보여준다
		// 생성모드인지, 수정모드인지 알기 위해 mode파라미터로 받음

		System.out.println("/write 글 작성 모드" + mode);

		if (mode.contentEquals("edit")) {
//			System.out.println("수정할 글 넘버" + VO.getBoardSeq());
			// 수정 버튼 클릭하면 보일 글 작성양식에 보일 수정할 게시글 내용
			TestVO content = getData.viewContent(vo);
			System.out.println(content.toString());

			// 수정할 게시글 내용 글 작성 양식에 보내줌
			model.addAttribute("content", content);
		}

		// 파라미터로 받은 모드를 글 작성 화면에 보내줌
		model.addAttribute("mode", mode);

		return "/test/writingForm";
	}

	// 글 생성, method는 post로만 받도록 함
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadContent(Model model, MultipartHttpServletRequest request,
			@RequestParam("fileUpload") MultipartFile newfile) {
		System.out.println("ctr upload까지 들어옴");
		TestVO vo = new TestVO();
		try {
			vo.setBoardTitle(request.getParameter("boardTitle"));
			vo.setBoardContent(request.getParameter("boardContent"));
			vo.setNickNm(request.getParameter("nickNm"));

			System.out.println("ctr testVO생성및 내용 주입");
			// 파일이 있으면 fileVO사용해서 저장 및 이름을 testVO에 함께 넣어 보냄
			if (newfile != null) {
				// 파일 업로드
				FileVO fileupload = new FileVO();
				// 파일 업로드/저장 경로
				String filename = fileupload.fileOutput(newfile);
				// 파일을 볼 수 있는 경를 testVO의 파일 이름으로 주입

				vo.setFileName(filename);
				int createdRowNum = getData.createContent(vo);
			} else {
				int createdRowNum = getData.createContent(vo);
				System.out.println("ctr 파일없이 글생성성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: ../main6";
	}

	// 글 수정, method는 post로만 받도록 함
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editContent(TestVO vo) {
		// 수정내용 db에 보내기
		int updatedRowNum = getData.updateContent(vo);
		System.out.println("수정성공" + updatedRowNum);
		return "redirect: ../main6";
	}

	// 댓글 달기 기능
	@RequestMapping("/postCmt")
	public String postComment(TestVO vo, CmtVO cVO, Model model) {
		try {
			// 댓글 객체에 게시글 넘버 넣어준후 쿼리
			cVO.setBoardSeq(vo.getBoardSeq());
			int createdCMT = getData.createComment(cVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 댓글 추가 후 다시 해당 게시글 내용 가져오기
		TestVO content = new TestVO();
		content = getData.viewContent(vo);

		// 댓글 추가 후 추가된 댓글을 포함한 새 게시글의 댓글 목록 가져오기
		CmtVO addVO = new CmtVO();
		addVO.setBoardSeq(vo.getBoardSeq());
		List<CmtVO> newCmtList = new ArrayList<CmtVO>();
		newCmtList = getData.viewComment(cVO);
		// 상세보기 페이지에 게시글 내용 & 댓글 내용 보내줌
		model.addAttribute("cmtList", newCmtList);
		model.addAttribute("content", content);
		return "/test/viewContent";
	}

	// 첨부파일 삭제 기능
	@RequestMapping("/deleteFile")
	public String deleteFile(TestVO vo, Model model) {
		System.out.println("파일 삭제할 게시물 넘버 " + vo.getBoardSeq());
		int deleted = getData.deleteFile(vo);
		System.out.println("삭제 성공");
		return "redirect: ../view?boardSeq=" + vo.getBoardSeq();
	}

	@RequestMapping("/rcm")
	public String rcmUpdate(TestVO vo, Model model) {
		try {
			System.out.println("추천할 게시글 넘버 " + vo.getBoardSeq());
			int rcm = getData.rcmUpdate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: ../view?boardSeq=" + vo.getBoardSeq();
	}

}
