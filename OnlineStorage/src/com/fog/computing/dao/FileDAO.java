package com.fog.computing.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.fog.computing.pojo.File;

public class FileDAO {
	//CRUD on File table
	private Connection conn = null;
	private ServletContext context = null;
	private String find_files_by_user_id = "select * from file_table where user_id = ?";
	private String find_duplicate_file_combinations = "select * from file_table where user_id = ? and (file_id = ? or file_name = ?)";
	private String insert_new_file = "insert into file_table (file_id,file_name,file_type,user_id,file_size,upload_date,file_content,decoy_content) values (?,?,?,?,?,?,?,?)";
	private String get_registered_user_files = "select * from file_table";
	private String find_file_by_file_id = "select * from file_table where file_id = ?";

	public FileDAO(ServletContext context){
		this.context = context;
	}
	
	public int createFile(File file){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(insert_new_file);
			
			pStmt.setString(1, file.getFileId());
			pStmt.setString(2, file.getFileName());
			pStmt.setString(3, file.getFileType());
			pStmt.setString(4, file.getUserId());
			pStmt.setLong(5, file.getFileSize());
			pStmt.setDate(6, file.getUploadDate());
			
			java.io.File original = new java.io.File(file.getFilePath());
			FileInputStream fis = new FileInputStream(original);
			pStmt.setBinaryStream(7, fis, (int)original.length());
			
			java.io.File decoy = new java.io.File(file.getDecoyFilePath());
			FileInputStream fis2 = new FileInputStream(decoy);
			pStmt.setBinaryStream(8, fis2, (int)decoy.length());
			
			pStmt.executeUpdate();
			
			fis.close();
			fis2.close();
			disconnect();
		}catch(SQLException ex){
			ex.printStackTrace();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return 0;
	}
	public File findFile(String fileId){
		connect(context);
		File file = new File();
		try{
			PreparedStatement pStmt = conn.prepareStatement(find_file_by_file_id);
			pStmt.setString(1, fileId);
			
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				file.setFileId(rs.getString("FILE_ID"));
				file.setFileName(rs.getString("FILE_NAME"));
				file.setFileType(rs.getString("FILE_TYPE"));
				file.setUserId(rs.getString("USER_ID"));
				file.setFileSize(rs.getInt("FILE_SIZE"));
				file.setUploadDate(rs.getDate("UPLOAD_DATE"));
				file.setFileContent(rs.getBlob("FILE_CONTENT"));
				file.setDecoyContent(rs.getBlob("DECOY_CONTENT"));
				
				//Creating original file on server filesystem
				InputStream in = file.getFileContent().getBinaryStream();
				OutputStream out = new FileOutputStream("C:\\temp\\orig.txt");
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = in.read(buffer)) != -1){
					out.write(buffer,0,bytesRead);
				}
				
				in.close();
				out.close();
				
				//Creating dummy file on server filesystem
				in = file.getDecoyContent().getBinaryStream();
				out = new FileOutputStream("C:\\temp\\dummy.txt");
				
				buffer = new byte[4096];
				bytesRead = -1;
				
				while((bytesRead = in.read(buffer)) != -1){
					out.write(buffer,0,bytesRead);
				}
				
				in.close();
				out.close();
			}
			
			disconnect();
		}catch(SQLException ex){
			ex.printStackTrace();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return file;
	}
	
	public List<File> findFiles(List<File> files){
		return null;
	}
	
	public int updateFile(File file){
		return 0;
	}
	
	public int updateFiles(List<File> files){
		return 0;
	}
	
	public int deleteFile(File file){
		return 0;
	}
	
	public int deleteFiles(List<File> files){
		return 0;
	}
	
	public List<File> findFilesByUserId(String userId){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(find_files_by_user_id);
			
			pStmt.setString(1, userId);
			
			ResultSet rs = pStmt.executeQuery();
			
			return populateFiles(rs);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isFileDetailsDuplicate(String filename, String fileid, String userid){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(find_duplicate_file_combinations);
			
			pStmt.setString(1, userid);
			pStmt.setString(2, fileid);
			pStmt.setString(3, filename);
			
			ResultSet rs = pStmt.executeQuery();
			
			boolean isFileDuplicate = rs.next();
			
			disconnect();
			return isFileDuplicate;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public List<File> getRegisteredUsersFiles(){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(get_registered_user_files);
			
			ResultSet rs = pStmt.executeQuery();
			
			return populateFiles(rs);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	//Connection to DB initiated
	private void connect(ServletContext context) {
		String username = context.getInitParameter("dbuser");
		String password = context.getInitParameter("dbpassword");
		String dbURL = context.getInitParameter("dbURL");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + dbURL,
					username, password);

		} catch (Exception ex) {
			System.out
					.println("Something went wrong in the JDBC connect() method :: UserHelper.connect()");
			ex.printStackTrace();
		}
	}
	
	//Disconnection from DB initiated
	private void disconnect() {
		try {
			conn.close();
		} catch (SQLException ex) {
			System.out
					.println("Something went wrong while closing the connection :: UserHelper.disconnect()");
			ex.printStackTrace();
		}
	}
	
	private List<File> populateFiles(ResultSet rs){
		List<File> fileList = new ArrayList<File>();
		try{
			while(rs.next()){
				File file = new File();
				file.setDecoyContent(rs.getBlob("DECOY_CONTENT"));
				file.setFileContent(rs.getBlob("FILE_CONTENT"));
				file.setFileId(rs.getString("FILE_ID"));
				file.setFileName(rs.getString("FILE_NAME"));
				file.setFileSize(rs.getInt("FILE_SIZE"));
				file.setFileType(rs.getString("FILE_TYPE"));
				file.setUploadDate(rs.getDate("UPLOAD_DATE"));
				file.setUserId(rs.getString("USER_ID"));
				fileList.add(file);
			}
			disconnect();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return fileList;
	}
}
