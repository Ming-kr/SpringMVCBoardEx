package com.ja.springboard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.mail.HtmlEmail;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String test(@RequestParam HashMap<String,String> vo) {
		
		System.out.println("[test] : " + vo);
		vo.put("t_nick", "123");
		vo.put("t_pw", "123");
		testSQLMapper.insertHashMap(vo);
		//vo = new TestVO(null,null,"a","a");
		
		//testSQLMapper.insert(vo);
		
		//ArrayList<HashMap<String,String>> list = testSQLMapper.selectHashMap();
		
		//System.out.println(list);
		
		//ArrayList<Integer> listT_idx = new ArrayList<Integer>();
		//listT_idx.add(1);

		ArrayList<String> listT_id = new ArrayList<String>();
		listT_id.add("a");
		listT_id.add("b");
		
		ArrayList<TestVO> list = testSQLMapper.selectIn(listT_id);
		
		System.out.println(list);		
		
		//이것 저것 테스트...
		ArrayList<String> listId = testSQLMapper.selectId("'a','b'");
		System.out.println("listId : " + listId);
		
		return "/test";
	}
	@RequestMapping("/testMail")
	public void testMail() {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";		
		String hostSMTPid = "s001lec@naver.com"; // 본인의 아이디 입력		
		String hostSMTPpwd = "passwd"; // 비밀번호 입력
		
		// 보내는 사람 EMail, 제목, 내용 
		String fromEmail = "s001lec@naver.com"; // 보내는 사람 eamil
		String fromName = "test";  // 보내는 사람 이름
		String subject = "이메일 발송 테스트"; // 제목
		
		// 받는 사람 E-Mail 주소
		String mail = "s001352@gmail.com";  // 받는 사람 email		
		
		//E-Mail 본문 내용
		String msg = "<p>이메일 발송 테스트 입니다.</p>";
		
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);	// SMTP 포트 번호 입력

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

//hashmap으로 파라미터 값 매핑시에 리솔버 구현해서 프레젠테이션 레이어에 관련 등록 해야 된다.
//그냥 해도됨....위에 @RequestParam...설정으로 완료 되는듯.
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

/*
class ListMapTypeHandler implements TypeHandler<Object> {
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		
		List<String> list = (List<String>)parameter;
		System.out.println("parameter:" + parameter);
		//parameter:[윈도우98.jpg, googlelogo.jpg]
		System.out.println("list:" + list);
		//list:[윈도우98.jpg, googlelogo.jpg]
		
		String[]  strings = new String[list.size()];
		for (int j = 0; j < list.size(); j++) {
			strings[j] = list.get(j);
			System.out.println(list.get(j));
			//윈도우981234.jpg
			//googlelogo1234.jpg
		}
		
		//db연결
		CommonsDbcpNativeJdbcExtractor extractor = new CommonsDbcpNativeJdbcExtractor();
		Connection conn = extractor.getNativeConnection(ps.getConnection());
		
		//오라클의 FILE_ARRAY타입을 사용하겠다.
		ArrayDescriptor desc = ArrayDescriptor.createDescriptor("FILE_ARRAY",conn);
		
		//오라클에 있는 ARRAY 타입으로 변환.->오라클이 배열을 받을 수 있게 함.
		parameter = new ARRAY(desc, conn, strings); 
		
		ps.setArray(i, (oracle.sql.ARRAY)parameter);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.wasNull()) { //결과가 null일때
			return null; 
		} else {
			return cs.getString(columnIndex);
		}
	}

}
*/









