package com.aritra;
import java.io.Serializable;
/*
 * 
 * A JavaBean is Java code following the JavaBeans API specifications.

   A JavaBean has the following features.

   It has a default, no-argument constructor.

   It should implement the Serializable interface.

   It has a list of properties for reading or writing.

   It has a list of getter and setter methods for the properties.
   
 */

public class StudentsBean implements Serializable{
	private String firstName = null;
	private String lastName = null;
	private int age = 0;
	
	public StudentsBean(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
