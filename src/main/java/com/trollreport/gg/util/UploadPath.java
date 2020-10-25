package com.trollreport.gg.util;

import javax.servlet.http.HttpServletRequest;

public class UploadPath {

	public static String attach_path="C:\\TrollResource\\image";
	
	public static String path( HttpServletRequest request){
		String uploadPath ="/";
		try{
			
			String root_path =request.getSession().getServletContext().getRealPath("/");
				
			uploadPath=attach_path.replace('/', '\\');;	  
			
			return uploadPath;
		}catch(Exception e){
			e.printStackTrace();
		
			return uploadPath;
		}
	}
}