package com.fog.computing.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class File implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fileId;
	private String fileName;
	private String fileType;
	private String userId;
	private long fileSize;
	private Date uploadDate;
	private Blob fileContent;
	private Blob decoyContent;
	private String filePath;
	private String decoyFilePath;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDecoyFilePath() {
		return decoyFilePath;
	}
	public void setDecoyFilePath(String decoyFilePath) {
		this.decoyFilePath = decoyFilePath;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Blob getFileContent() {
		return fileContent;
	}
	public void setFileContent(Blob fileContent) {
		this.fileContent = fileContent;
	}
	public Blob getDecoyContent() {
		return decoyContent;
	}
	public void setDecoyContent(Blob decoyContent) {
		this.decoyContent = decoyContent;
	}
}
