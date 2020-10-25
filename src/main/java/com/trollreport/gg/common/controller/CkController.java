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
		//CKEditor ���� ������ �Ѱ��ִ� �̸��� upload �� ���� �Ǿ� �ִ�. �ݵ�� upload �� ����
				System.out.println("hi");
				
				OutputStream out =null;
				PrintWriter printWriter =null;
				
				String fileName =upload.getOriginalFilename(); //÷�� ���� �̸�
				byte[] bytes =upload.getBytes(); //÷�������� ����Ʈ �迭�� ����
			    

				//String uploadPath ="���ε��� ���丮 ���" + fileName; //������ ���� �����
			    String uploadPath = UploadPath.path(request) +fileName;
				
			    out=new FileOutputStream(new File(uploadPath));
			    out.write(bytes); //������ ���� ���ε�
			    
			    Gson gson = new Gson();
			    
			    //�̹��� �ٲܶ� ��Ĺ������ �������
			    String fileUrl = "/troll" + "/image/" + fileName;
			    ImageSuccess imagesuccess = new ImageSuccess(fileUrl, 1);
			    
			    //��� ����
			    response.setContentType("application/json");
	            response.setHeader("Cache-Control", "nocache");
	            response.setCharacterEncoding("utf-8");
				
			    String successJson = gson.toJson(imagesuccess);
			    System.out.println(successJson);
			    
			    printWriter = response.getWriter();
			    printWriter.print(successJson);
    }
}
