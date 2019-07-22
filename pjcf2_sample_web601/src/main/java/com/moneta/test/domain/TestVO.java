package com.moneta.test.domain;

import org.springframework.stereotype.Component;

@Component
public class TestVO {
	private int boardSeq;
	private String memberId;
	private String nickNm;
	private String boardTitle;
	private String boardContent;
	private String regDt;
	private String updateDt;
	private String fileName;
	private String fileServerName;
	private int viewCnt;
	private int rowNum;
	private int rcmNum; //추천수
	
	public int getRcmNum() {
		return rcmNum;
	}
	public void setRcmNum(int rcmNum) {
		this.rcmNum = rcmNum;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickNm() {
		return nickNm;
	}
	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileServerName() {
		return fileServerName;
	}
	public void setFileServerName(String fileServerName) {
		this.fileServerName = fileServerName;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "TestVO [boardSeq=" + boardSeq + ", memberId=" + memberId + ", nickNm=" + nickNm + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", regDt=" + regDt + ", updateDt=" + updateDt
				+ ", fileName=" + fileName + ", fileServerName=" + fileServerName + ", viewCnt=" + viewCnt + ", rowNum="
				+ rowNum + "]";
	}
	
}
