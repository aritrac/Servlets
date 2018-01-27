package com.fog.computing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.fog.computing.pojo.Download;

public class DownloadDAO {
	//CRUD on Download table
		private Connection conn = null;
		private ServletContext context = null;
		
		private String create_download_entry = "insert into download_table values(?,?,?,?,?)";
		private String get_entries_by_user_id = "select * from download_table where user_id = ?";
		
		public DownloadDAO(ServletContext context){
			this.context = context;
		}
		
		public int createDownload(Download download){
			return 0;
		}
		public Download findDownload(Download download){
			return null;
		}
		
		public List<Download> findFiles(List<Download> downloads){
			return null;
		}
		
		public int updateDownload(Download download){
			return 0;
		}
		
		public int updateDownloads(List<Download> download){
			return 0;
		}
		
		public int deleteDownload(Download download){
			return 0;
		}
		
		public int deleteDownloads(List<Download> downloads){
			return 0;
		}
		
		public void createEntry(Download download){
			connect(context);
			try{
				PreparedStatement pStmt = conn.prepareStatement(create_download_entry);
				pStmt.setString(1, download.getFileID());
				pStmt.setString(2, download.getFileName());
				pStmt.setString(3, download.getIsSuccessful());
				pStmt.setString(4, download.getUserId());
				pStmt.setDate(5, download.getDownloadTime());
				
				pStmt.executeUpdate();
				
				disconnect();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
		public List<Download> getEntriesByUserId(String userId){
			connect(context);
			List<Download> entries = new ArrayList<Download>();
			try{
				PreparedStatement pStmt = conn.prepareStatement(get_entries_by_user_id);
				pStmt.setString(1, userId);
				
				ResultSet rs = pStmt.executeQuery();
				
				while(rs.next()){
					Download download = new Download();
					download.setFileID(rs.getString("FILE_ID"));
					download.setFileName(rs.getString("FILE_NAME"));
					download.setIsSuccessful(rs.getString("IS_SUCCESSFUL"));
					download.setUserId(rs.getString("USER_ID"));
					download.setDownloadTime(rs.getDate("DOWNLOAD_TIME"));
					
					entries.add(download);
				}
				
				disconnect();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			return entries;
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
}
