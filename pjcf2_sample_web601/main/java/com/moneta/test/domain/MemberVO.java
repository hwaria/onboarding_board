package com.moneta.test.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	int memberNo; // 회원넘버
	String memberId; // 회원 아이디
	String memberPw; // 회원 비밀번호
	String memberName; // 회원 이름
	String nickNm; // 회원 필명
	int gender; // 성
	String email; // 회원 이메일주소
	String phone; // 회원 폰번호
	Date regDt; // 가입일
	Date leaveDt; // 탈퇴일
	int grade; // 회원 등급
	String memberStatus; // 회원 상태
	String salt; //비밀번호 암호화를 위한 난수
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNickNm() {
		return nickNm;
	}
	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public Date getLeaveDt() {
		return leaveDt;
	}
	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int i) {
		this.grade = i;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + memberName
				+ ", nickNm=" + nickNm + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", regDt="
				+ regDt + ", leaveDt=" + leaveDt + ", grade=" + grade + ", memberStatus=" + memberStatus + "]";
	}
	
}
