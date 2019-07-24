package com.moneta.test.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileVO {
	private int boardSeq; //파일이 첨부된 게시글 넘버
	private String fileName; //파일의 저장 이름
	private String orgFileName; //파일의 실제 이름
	private String fileUrl; //파일의 보여주는 경로
	private String currentDate;
	
	public String fileOutput(MultipartFile file) {	
		//폴더명을 날짜명으로 지정 및 파일명 앞에 업로드 날짜 붙이기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		currentDate = sdf.format(System.currentTimeMillis());
		
		//저장 경로
		String loadUrl = "d://file/" + currentDate;
		//url
		String url = "http://localhost:8080/file/"; 
				
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		try {
			setOrgFileName(file);
			setFileUrl(url);
			byte[] bytes = file.getBytes();
			//폴더 생성하기 
			File newfile = new File(loadUrl);
			if(!newfile.exists()) {
				newfile.mkdirs();
				System.out.println("폴더 생성");			
			}
			//생성된 폴더 안에 파일 넣기
			if(newfile.exists()) {
				fileName = currentDate + "_" + orgFileName;
				newfile = new File(loadUrl + "/" + fileName);
			}
			out = new FileOutputStream(newfile);
			out.write(bytes);
			
		}	catch (Exception e) {
            e.printStackTrace();
        } 	finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (printWriter != null) {
	                    printWriter.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
        }
		
		return fileUrl + fileName;
	}
	 
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String orgFileName) {
		
		
		this.fileName = currentDate + "_" + orgFileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	
	public void setOrgFileName(MultipartFile file) {
		
		this.orgFileName = file.getOriginalFilename();
		setFileName(orgFileName);
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String url) {
		
		this.fileUrl = url + currentDate + "/";
	}
	
	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
	
}