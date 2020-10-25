package com.trollreport.gg.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.trollreport.gg.util.ImageSuccess;
import com.trollreport.gg.util.UploadPath;

@Controller
@RequestMapping(value = "/ck")
public class CkController {
	@RequestMapping("/fileUpload.do")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception{
		//CKEditor 에서 파일을 넘겨주는 이름이 upload 로 설정 되어 있다. 반드시 upload 로 설정
				System.out.println("hi");
				
				OutputStream out =null;
				PrintWriter printWriter =null;
				
				String fileName =upload.getOriginalFilename(); //첨부 파일 이름
				byte[] bytes =upload.getBytes(); //첨부파일을 바이트 배열로 저장
			    

				//String uploadPath ="업로드할 디렉토리 경로" + fileName; //물리적 실제 저장소
			    String uploadPath = UploadPath.path(request) +fileName;
				
			    out=new FileOutputStream(new File(uploadPath));
			    out.write(bytes); //서버에 파일 업로드
			    
			    Gson gson = new Gson();
			    
			    //이미지 바꿀때 톰캣설정도 해줘야함
			    String fileUrl = "/troll" + "/image/" + fileName;
			    ImageSuccess imagesuccess = new ImageSuccess(fileUrl, 1);
			    
			    //헤더 설정
			    response.setContentType("application/json");
	            response.setHeader("Cache-Control", "nocache");
	            response.setCharacterEncoding("utf-8");
				
			    String successJson = gson.toJson(imagesuccess);
			    System.out.println(successJson);
			    
			    printWriter = response.getWriter();
			    printWriter.print(successJson);
    }
}
