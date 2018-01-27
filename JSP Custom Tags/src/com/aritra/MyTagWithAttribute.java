package com.aritra;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTagWithAttribute extends SimpleTagSupport{
	private String message;
	private Boolean attribute_name1;
	private Date attribute_name2;
	
	public Date getAttribute_name2() {
		return attribute_name2;
	}

	public void setAttribute_name2(Date attribute_name2) {
		this.attribute_name2 = attribute_name2;
	}

	public Boolean getAttribute_name1() {
		return attribute_name1;
	}

	public void setAttribute_name1(Boolean attribute_name1) {
		this.attribute_name1 = attribute_name1;
	}

	public void setMessage(String msg){
		this.message = msg;
	}
	
	public void doTag() throws JspException, IOException{
		if(message != null){
			JspWriter out = getJspContext().getOut();
			out.println(message);
		}else{
			getJspContext().getOut().println("No Message!");
		}
	}
}
