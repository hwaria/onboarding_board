package com.moneta.test.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.moneta.test.domain.FileVO;
import com.moneta.test.domain.TestVO;
import com.moneta.test.service.impl.GetDataService;

@Controller
public class CreateController {

		@Resource // 게시글 변수가 담겨있는 클래스
		TestVO TestVO;
	
		@Resource
		GetDataService getData;

		// 글 작성 폼 보여주기
		@RequestMapping("/write")
		public String writeContent(String mode, TestVO vo, Model model) {
			// 글 생성/수정 버튼을 누를 경우 글 작성 폼을 보여준다
			// 생성모드인지, 수정모드인지 알기 위해 mode파라미터로 받음

			if (mode.contentEquals("edit")) {
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
			
			TestVO vo = new TestVO();
			try {
				vo.setBoardTitle(request.getParameter("boardTitle"));
				vo.setBoardContent(request.getParameter("boardContent"));
				vo.setNickNm(request.getParameter("nickNm"));

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
					System.out.println("파일 없음");
					int createdRowNum = getData.createContent(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect: ../main6";
		}

}
