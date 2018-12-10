package com.ja.springboard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ja.springboard.mapper.TestSQLMapper;
import com.ja.springboard.vo.TestVO;

@Controller
public class TestController {
	
	@Autowired
	TestSQLMapper testSQLMapper;
	
	
	@RequestMapping("/testRest/{cat}/{pid}")
	public String testRest(
			@PathVariable("cat") String cat ,
			@PathVariable("pid") String pid) {
		
		System.out.println("cat : " + cat);
		System.out.println("pid : " + pid);
		
		return "/test";
	}
	
	@RequestMapping("/test")
	//public String test(TestVO vo){
	public String test(HashMap<String,String> vo) {
		
		System.out.println("[test] : " + vo);
		vo.put("t_nick", "123");
		vo.put("t_pw", "123");
		testSQLMapper.insertHashMap(vo);
		//vo = new TestVO(null,null,"a","a");
		
		//testSQLMapper.insert(vo);
		
		ArrayList<HashMap<String,String>> list = testSQLMapper.selectHashMap();
		
		System.out.println(list);
		
		return "/test";
	}
	
}

//hashmap으로 파라미터 값 매핑시에 리솔버 구현해서 프레젠테이션 레이어에 관련 등록 해야 된다.
//http://lemontia.tistory.com/417
class CustomArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}










