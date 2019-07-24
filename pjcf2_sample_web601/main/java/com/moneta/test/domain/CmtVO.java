package com.moneta.test.domain;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CmtVO {
	int cmtSeq; //댓글 넘버
	int boardSeq; //댓글이 달린 게시물 넘버
	String bbsId; 
	int highCmtSeq;
	int rcmNum; //추천수
	String regmnId;
	String regmnNickNm; //댓글 작성자 닉네임
	Date regDate; //등록일
	Date delDate; //삭제일 
	String cntn; // 댓글 내용
	
	public int getCmtSeq() {
		return cmtSeq;
	}
	public void setCmtSeq(int cmtSeq) {
		this.cmtSeq = cmtSeq;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBbsId() {
		return bbsId;
	}
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	public int getHighCmtSeq() {
		return highCmtSeq;
	}
	public void setHighCmtSeq(int highCmtSeq) {
		this.highCmtSeq = highCmtSeq;
	}
	public int getRcmNum() {
		return rcmNum;
	}
	public void setRcmNum(int rcmNum) {
		this.rcmNum = rcmNum;
	}
	public String getRegmnId() {
		return regmnId;
	}
	public void setRegmnId(String regmnId) {
		this.regmnId = regmnId;
	}
	public String getRegmnNickNm() {
		return regmnNickNm;
	}
	public void setRegmnNickNm(String regmnNickNm) {
		this.regmnNickNm = regmnNickNm;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getCntn() {
		return cntn;
	}
	public void setCntn(String cntn) {
		this.cntn = cntn;
	}
	
}
