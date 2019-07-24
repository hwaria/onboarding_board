package com.moneta.test.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping("ajaxTest")
	public String ajaxTest() {
		
		return "/test/ajaxTest";
	}

	@RequestMapping("testAjax")
	@ResponseBody 
	public HashMap<String, Object> testAjax(@RequestBody Map<String, Object> param) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println("데이타값->"+param.get("id"));
		
		map.put("res", "ok");
		
		return map;
		
		//return "/test/ajaxTest";
	}
	
	@RequestMapping("showForm")
	public String showForm(@RequestBody Map<String, Object> data) {
		
		System.out.println("컨트롤러옴" + data.get("a"));
		
		return "/test/ajaxForm";
				
	}
	
}
