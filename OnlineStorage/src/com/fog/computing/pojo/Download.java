package com.fog.computing.pojo;

import java.sql.Date;

public class Download {
	private String fileID;
	private String fileName;
	private String isSuccessful;
	private String userId;
	private Date downloadTime;
	public String getFileID() {
		return fileID;
	}
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIsSuccessful() {
		return isSuccessful;
	}
	public void setIsSuccessful(String isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(Date downloadTime) {
		this.downloadTime = downloadTime;
	}
}
