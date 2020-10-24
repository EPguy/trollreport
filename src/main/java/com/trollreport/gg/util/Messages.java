package com.trollreport.gg.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class Messages {
	
	public static void getScriptAlert(HttpServletResponse response, String msg) {
		getScriptAlert(response, msg, "UTF-8");
	}
	
	public static void getScriptAlert(HttpServletResponse response, String msg, String charset) {
		response.setContentType("text/html");
		
		String alert = "<!DOCTYPE html><head><meta http-equiv='Content-Type' content='text/html; charset="+charset+"'>";
		alert = alert + "<script type='text/javascript'>alert('" + msg + "');window.close();</script><title>TROLLREPORT.GG</title></head><body></body></html>";
		try {
			byte[] b = alert.getBytes(charset);
			
			ServletOutputStream sos;

			sos = response.getOutputStream();
			sos.write(b);
			sos.flush();		
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();		
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	public static void getScriptAlertGoBack(HttpServletResponse response, String msg) {
		getScriptAlertGoBack(response, msg, "UTF-8");
	}
	
	public static void getScriptAlertGoBack(HttpServletResponse response, String msg, String charset) {
		response.setContentType("text/html");
		
		String alert = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=" + charset + "'>";
		alert = alert + "<script type='text/javascript'>alert('" + msg + "');history.back();</script></head><body></body></html>";
		
		try {
			byte[] b = alert.getBytes(charset);
			
			ServletOutputStream sos;

			sos = response.getOutputStream();
			sos.write(b);
			sos.flush();		
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();		
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
	}
}