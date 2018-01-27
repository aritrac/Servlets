package com.fog.computing.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNo;
	private String address;
	private Date startTime;
	private Date endTime;
	private String securityQuestion;
	private String securityAnswer;
	private String userType;
	private Date creationDate;
	private int startHH;
	private int startMM;
	private int endHH;
	private int endMM;
	private String securityQuestion2;
	private String securityAnswer2;
	private String securityQuestion3;
	private String securityAnswer3;
	private String securityQuestion4;
	private String securityAnswer4;
	private String securityQuestion5;
	private String securityAnswer5;
	private String uniqueCode;
	private String state;
	private String city;
	private String zipCode;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getSecurityQuestion2() {
		return securityQuestion2;
	}
	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}
	public String getSecurityAnswer2() {
		return securityAnswer2;
	}
	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}
	public String getSecurityQuestion3() {
		return securityQuestion3;
	}
	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}
	public String getSecurityAnswer3() {
		return securityAnswer3;
	}
	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}
	public String getSecurityQuestion4() {
		return securityQuestion4;
	}
	public void setSecurityQuestion4(String securityQuestion4) {
		this.securityQuestion4 = securityQuestion4;
	}
	public String getSecurityAnswer4() {
		return securityAnswer4;
	}
	public void setSecurityAnswer4(String securityAnswer4) {
		this.securityAnswer4 = securityAnswer4;
	}
	public String getSecurityQuestion5() {
		return securityQuestion5;
	}
	public void setSecurityQuestion5(String securityQuestion5) {
		this.securityQuestion5 = securityQuestion5;
	}
	public String getSecurityAnswer5() {
		return securityAnswer5;
	}
	public void setSecurityAnswer5(String securityAnswer5) {
		this.securityAnswer5 = securityAnswer5;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getStartHH() {
		return startHH;
	}
	public void setStartHH(int startHH) {
		this.startHH = startHH;
	}
	public int getStartMM() {
		return startMM;
	}
	public void setStartMM(int startMM) {
		this.startMM = startMM;
	}
	public int getEndHH() {
		return endHH;
	}
	public void setEndHH(int endHH) {
		this.endHH = endHH;
	}
	public int getEndMM() {
		return endMM;
	}
	public void setEndMM(int endMM) {
		this.endMM = endMM;
	}
	
	public String getFromTime(){
		return startHH + " HH" + startMM + " MM";
	}
	
	public String getToTime(){
		return endHH + " HH" + endMM + " MM";
	}
	
}
