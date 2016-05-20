package com.mvcdemoweb.model.dao;

import java.util.ArrayList;

import com.mvcdemoweb.model.dto.Upload;
import com.mvcdemoweb.model.dto.UploadFile;

public interface UploadDao {

	int insertUpload(Upload upload);

	void insertUploadFile(UploadFile file);

	ArrayList<Upload> getUploadList();

	Upload getUploadByUploadNo(int uploadNo);

	ArrayList<UploadFile> getUploadFilesByUploadNo(int uploadNo);

	UploadFile getUploadFileByUploadFileNo(int uploadFileNo);

}