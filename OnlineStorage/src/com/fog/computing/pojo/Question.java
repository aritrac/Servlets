package com.fog.computing.pojo;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	private String questionId;
	private String securityQuestion;
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
}
