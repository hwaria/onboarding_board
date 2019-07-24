package com.moneta.test.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moneta.common.SHA256Util;
import com.moneta.test.domain.MemberVO;
import com.moneta.test.service.PagingService;
import com.moneta.test.service.impl.LoginService;
import com.moneta.test.service.impl.MemberRegService;

@Controller
public class MemberController {
	@Resource
	MemberRegService memberReg;

	@Resource
	MemberVO memberVO;

	@Resource
	PagingService paging;

	@Resource
	LoginService loginService;

	// 회원가입 버튼 클릭하면 회원가입 양식페이지 보여주기
	@RequestMapping("/moveToReg")
	public String moveToRegForm() {

		return "/test/member/memberRegForm";
	}

	// 아이디 중복 체크
	@RequestMapping("/idCheck")
	@ResponseBody // 화면에서 아이디값을 json형식으로 던져줄때
	public HashMap<String, Object> idCheck(@RequestBody Map<String, Object> id) {
		System.out.println("id: " + id.get("id"));
		HashMap<String, Object> map = new HashMap<String, Object>();

		int res = memberReg.idCheck((String) id.get("id"));
		System.out.println(res);
		map.put("res", res);

		return map;
	}

	// 회원 가입
	@RequestMapping(value = "/memberRegistration", method = RequestMethod.POST)
	@ResponseBody
	public int newMember(@ModelAttribute MemberVO newMember) {

		System.out.println(newMember.toString());
		int registrationResult = 0;
		try {
			// 비번 암호화
			String salt = SHA256Util.generateSalt(); // 솔트만들기
			newMember.setSalt(salt);
			String pw = newMember.getMemberPw(); // 사용자가 입력한 패스워드를 받아서
			pw = SHA256Util.getEncrypt(pw, salt); // 난수(솔트)와 함께 암호화
			newMember.setMemberPw(pw);

			registrationResult = memberReg.memberRegistration(newMember);
			System.out.println("가입성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return registrationResult;
	}

	//로그인버튼 클릭
	@RequestMapping("/login")
	public String login() {
		
		return "/test/login";
	}
	// 로그인
	@RequestMapping(value = "/logging", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> loggingIn(MemberVO loginVO) throws IOException {
		System.out.println("컨트롤러 회원 아이디, 비번" + loginVO.toString());
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 해당 아이디의 솔트값 가져오기
		String salt = loginService.getSaltById(loginVO); 

		String passwordInput = loginVO.getMemberPw(); // 입력받은 비번
		// 솔트값과 입력받은 비번을 취합해서 만든 암호화된 비번
		String passwordTry = SHA256Util.getEncrypt(passwordInput, salt); 
		loginVO.setMemberPw(passwordTry);

		String storedPw = loginService.checkPassword(loginVO); // db에 저장된 암호화된 비번

		int res = 0;
		if (passwordTry.equals(storedPw)) { //db에 저장된 비번과 입력받은 비번을 비교해서 일치하면 1을 리턴
			res = 1;
		}
		
		map.put("res", res);

		return map;
	}
}
