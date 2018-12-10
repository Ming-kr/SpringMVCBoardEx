package com.ja.springboard.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ja.springboard.service.ContentService;
import com.ja.springboard.vo.AttachImgFileVO;
import com.ja.springboard.vo.BoardDataVO;
import com.ja.springboard.vo.ContentVO;
import com.ja.springboard.vo.SessionUserData;

@Controller
public class ContentController {

	public ContentController() {
		System.out.println("[init] ContentController 로드 : ");
	}
	
	@Autowired
	ContentService contentService;
	
	//단순 매핑용
	@RequestMapping("/writeContentForm")
	public String writeContentForm() {
		return "/writeContentForm";
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return board(model);
	}
	
	//로직 처리용
	@RequestMapping("/writeContentFormAction")
	public String writeContentFormAction(MultipartFile[] files,ContentVO requestContentVO , HttpSession session) {
	
		ArrayList<AttachImgFileVO> fileDataList = 
				new ArrayList<AttachImgFileVO>(); 
		
		//String uploadRootPath = "C:\\prod\\apache-tomcat-8.0.53\\wtpwebapps\\SpringMVCBoardEx\\uploadimg\\";
		//String uploadRootPath = "c:\\upload\\";
		//for Linux
		//String uploadRootPath = "/upload/";
		//for Linux And Windows
		String uploadRootPath = new File("/upload").getAbsolutePath();

		//날짜별 폴더 확인 및 생성...
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateFolder = sdf.format(date);
		dateFolder = dateFolder.replace("-", File.separator);
		
		File uploadPath = new File(uploadRootPath,dateFolder); 		
		
		
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
			
		}
		
		for(MultipartFile file : files) {
			if(file.isEmpty()) continue;
			
			//파일명 변경...시간 / 랜덤.
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString();
			
			String oriFileName = file.getOriginalFilename();
			
			uploadFileName += 
					oriFileName.substring(oriFileName.indexOf("."));
			
			//파일 저장...
			File saveFile = new File(uploadPath,uploadFileName);
			
			try {
				file.transferTo(saveFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//DB 넣을 값 세팅...
			AttachImgFileVO fileData = new AttachImgFileVO();
			
			String tempString = "/uploadimg/";
			tempString += dateFolder.replace(File.separator, "/");
			tempString += "/";
			tempString += uploadFileName;
			
			fileData.setF_savedfilename(tempString);
			
			fileDataList.add(fileData);
		}
		
		
		
		SessionUserData user = 
	(SessionUserData)session.getAttribute("sessionUserData");
		requestContentVO.setM_idx(user.getM_idx());
		
		contentService.writeContent(requestContentVO,fileDataList);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/board")
	public String board(Model model) {
		
		ArrayList<BoardDataVO> boardDataList = 
				contentService.getContentList();
		
		model.addAttribute("boardDataList", boardDataList);
		
		return "/board";
	}
	
	@RequestMapping("/readContentForm")
	public String readContentForm(ContentVO requestContentVO , Model model) {
		
		BoardDataVO data = contentService.getContent(requestContentVO);		
		
		model.addAttribute("data" , data);
		
		return "/readContentForm";
	}
	
	@RequestMapping("/deleteContent")
	public String deleteContent(ContentVO requestContentVO) {
		
		contentService.deleteContent(requestContentVO);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/updateContentForm")
	public String updateContent(ContentVO requestContentVO , Model model) {
		
		BoardDataVO data = 
				contentService.getContent(requestContentVO);
		
		model.addAttribute("data" , data);
		
		return "/updateContentForm";
	}
	
	@RequestMapping("/updateContentFormAction")
	public String updateContentFormAction(ContentVO requestContentVO) {
		
		contentService.updateContent(requestContentVO);
		
		return "redirect:/board";
	}
	
	
}












