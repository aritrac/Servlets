package com.aritra;

import java.io.Serializable;

public class BoxBean implements Serializable{
	private int height;
	private int length;
	private int breadth;
	
	public BoxBean(){
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	
}
