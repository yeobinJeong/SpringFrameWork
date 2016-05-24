package com.mvcdemoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mvcdemoweb.model.dto.Upload;
import com.mvcdemoweb.model.dto.UploadFile;
import com.mvcdemoweb.model.mapper.UploadMapper;

@Repository(value = "oracleUploadDao")
public class OracleUploadDao implements UploadDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	@Qualifier("uploadMapper")
	private UploadMapper uploadMapper;

	public int insertUpload(Upload upload) {

		// 자동 증가된 키 값을 저장할 객체
		/*
		 * KeyHolder keyHolder = new GeneratedKeyHolder();
		 * 
		 * jdbcTemplate.update(new PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(
		 * Connection con) throws SQLException {
		 * 
		 * String sql = "INSERT INTO upload " +
		 * "(uploadno, title, uploader, content) " +
		 * "VALUES (upload_sequence.nextVal, ?, ?, ?)";
		 * 
		 * PreparedStatement pstmt = con.prepareStatement(sql, new String[] {
		 * "uploadno" } );//반환될 키 컬럼 목록 pstmt.setString(1, upload.getTitle());
		 * pstmt.setString(2, upload.getUploader()); pstmt.setString(3,
		 * upload.getContent());
		 * 
		 * return pstmt; }
		 * 
		 * }, keyHolder);
		 */// update 수행 후 자동증가 값 조회하고 keyHolder에 저장
		uploadMapper.insertUpload(upload);
		/*int keyNum =*/ 

		return upload.getUploadNo();
	}

	public void insertUploadFile(UploadFile file) {
		/*
		 * String sql = "INSERT INTO uploadfile " +
		 * "(uploadfileno, uploadno, savedfilename, userfilename) " +
		 * "VALUES (uploadfile_sequence.nextVal, ?, ?, ?)";
		 * 
		 * jdbcTemplate.update(sql, file.getUploadNo(), file.getSavedFileName(),
		 * file.getUserFileName());
		 */
		uploadMapper.insertUploadFile(file);
	}

public Upload getUploadByUploadNo(int uploadNo) {
		
//		String sql = "SELECT uploadno,title,uploader, " + "content, regdate " + "FROM upload "
//				+ "WHERE uploadno = ? AND deleted = '0'";
//		
//		Upload upload = jdbcTemplate.queryForObject(sql, new Object[] { uploadNo }, new RowMapper<Upload>() {
//
//			@Override
//			public Upload mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Upload upload = new Upload();
//				upload.setUploadNo(uploadNo);
//				upload.setTitle(rs.getString(2));
//				upload.setUploader(rs.getString(3));
//				upload.setContent(rs.getString(4));
//				upload.setRegDate(rs.getDate(5));
//				return upload;
//			}
//		});
//		
//		upload.setFiles(getUploadFilesByUploadNo(uploadNo));
//		
//		return upload;
		
		Upload upload = uploadMapper.selectUploadByUploadNo(uploadNo);
		ArrayList<UploadFile> files = (ArrayList<UploadFile>)uploadMapper.selectUploadFilesByUploadNo(uploadNo);
		upload.setFiles(files);
		
		return upload;

	}

	public ArrayList<UploadFile> getUploadFilesByUploadNo(int uploadNo) {
		
//		String sql = "SELECT uploadfileno, uploadno, savedfilename, userfilename, downloadcount "
//				+ "FROM uploadfile WHERE uploadno = ?";
//		
//		List<UploadFile> files = jdbcTemplate.query(sql, new Object[] { uploadNo }, new RowMapper<UploadFile>() {
//
//			@Override
//			public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
//				UploadFile file = new UploadFile();
//				file.setUploadFileNo(rs.getInt(1));
//				file.setUploadNo(rs.getInt(2));
//				file.setSavedFileName(rs.getString(3));
//				file.setUserFileName(rs.getString(4));
//				file.setDownloadCount(rs.getInt(5));
//				return file;
//			}
//		});
//		return (ArrayList<UploadFile>)files;
		
		List<UploadFile> files = uploadMapper.selectUploadFilesByUploadNo(uploadNo);
		return (ArrayList<UploadFile>)files;

	}

	public UploadFile getUploadFileByUploadFileNo(int uploadFileNo) {
		
//		String sql = "SELECT uploadfileno, uploadno, savedfilename, userfilename "
//				+ "FROM uploadfile WHERE uploadfileno = ?";
//		
//		UploadFile file = jdbcTemplate.queryForObject(sql, new Object[] { uploadFileNo }, new RowMapper<UploadFile>() {
//
//			@Override
//			public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
//				UploadFile file = new UploadFile();
//				file.setUploadFileNo(rs.getInt(1));
//				file.setUploadNo(rs.getInt(2));
//				file.setSavedFileName(rs.getString(3));
//				file.setUserFileName(rs.getString(4));
//				return file;
//			}
//		});
//		return file;
		
		UploadFile file = uploadMapper.selectUploadFileByUploadFileNo(uploadFileNo);
		return file;
	}

	public void increaseUploadReadCount(int uploadNo) {

//		String sql = "UPDATE upload " + "SET readcount = readcount + 1 " + "WHERE uploadno = ?";
//		jdbcTemplate.update(sql, uploadNo);
		
		uploadMapper.increaseUploadReadCount(uploadNo);
	}

	public void increaseUploadFileDownloadCount(int uploadFileNo) {

//		String sql = "UPDATE uploadfile " + "SET downloadcount = downloadcount + 1 " + "WHERE uploadfileno = ?";
//		jdbcTemplate.update(sql, uploadFileNo);
		
		uploadMapper.increaseUploadFileDownloadCount(uploadFileNo);
	}

	public ArrayList<Upload> getUploadList() {

//		String sql = "SELECT uploadno, title, regdate from upload where deleted = '0'";
//		List<Upload> uploads = 
//			jdbcTemplate.query(sql, new RowMapper<Upload>() {
//
//			@Override
//			public Upload mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Upload upload = new Upload();
//				upload.setUploadNo(rs.getInt(1));
//				upload.setTitle(rs.getString(2));
//				upload.setRegDate(rs.getDate(3));
//				
//				return upload;
//			}
//			
//		});
//		
//		return (ArrayList<Upload>)uploads;
		
		ArrayList<Upload> uploads = (ArrayList<Upload>)uploadMapper.selectUploads();
		return uploads;

	}

}
