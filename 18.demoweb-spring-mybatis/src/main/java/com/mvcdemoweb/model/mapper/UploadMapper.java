package com.mvcdemoweb.model.mapper;

import java.util.List;

import com.mvcdemoweb.model.dto.Upload;
import com.mvcdemoweb.model.dto.UploadFile;

public interface UploadMapper {

	int insertUpload(Upload upload);
	void insertUploadFile(UploadFile file);
	List<Upload> selectUploads();
	Upload selectUploadByUploadNo(int uploadNo);
	List<UploadFile> selectUploadFilesByUploadNo(int uploadNo);
	UploadFile selectUploadFileByUploadFileNo(int uploadFileNo);
	void increaseUploadReadCount(int uploadNo);
	void increaseUploadFileDownloadCount(int uploadFileNo);
	
}



