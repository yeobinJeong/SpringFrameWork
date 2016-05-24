package com.mvcdemoweb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdemoweb.common.Util;
import com.mvcdemoweb.model.dao.UploadDao;
import com.mvcdemoweb.model.dto.Upload;
import com.mvcdemoweb.model.dto.UploadFile;
import com.mvcdemoweb.view.DownloadView;

@Controller
@RequestMapping(value = "/upload/")
public class UploadController {

	@Autowired
	@Qualifier(value = "oracleUploadDao")
	private UploadDao dao;
	
	@RequestMapping(value = "list.action", method = RequestMethod.GET)
	public String list(Model model) {

		List<Upload> uploads = dao.getUploadList();
		
		model.addAttribute("uploads", uploads);
		
		return "upload/uploadlist";
	}
	
	@RequestMapping(
		value = "write.action", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "upload/uploadwriteform";
	}
	
	@RequestMapping(
		value = "write.action", method = RequestMethod.POST)
	public String upload(
		MultipartHttpServletRequest req, Upload upload) {
		
		//1. 전송데이터 읽기
		String path = req.getRealPath("/WEB-INF/upload");//실제 파일을 저장할 경로

		try {
			//UploadFile 테이블에 insert할 데이터를 저장할 객체
			ArrayList<UploadFile> files = new ArrayList<>();

			MultipartFile file = req.getFile("attach");
			if (file != null && file.getSize() > 0) {
			
				String fileName = file.getOriginalFilename();
				//C:\\AAA\\BBB\\CCC.txt -> CCC.txt
				if (fileName.contains("\\")) {
					fileName = fileName.substring(
						fileName.lastIndexOf("\\") + 1);
				}
							
				String uniqueFileName =
					Util.getUniqueFileName(path, fileName);

				//업로드된 파일을 지정된 경로에 저장
				//(임시파일을 실제파일로 저장 or 메모리데이터를 파일로 저장)
				file.transferTo(new File(path, uniqueFileName));
							
				UploadFile f = new UploadFile();						
				f.setSavedFileName(uniqueFileName);
				f.setUserFileName(fileName);
				files.add(f);
			}
			
			//데이터베이스에 데이터 insert
			int newUploadNo = dao.insertUpload(upload);
			//Upload insert
			for (UploadFile uf : files) {
				uf.setUploadNo(newUploadNo);
				dao.insertUploadFile(uf);//UploadFile insert
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "redirect:/upload/list.action";
	}
	
	@RequestMapping(value = "view.action", method = RequestMethod.GET)
	public String view(
		@RequestParam("uploadno")int uploadNo, Model model) {
		
		Upload upload = dao.getUploadByUploadNo(uploadNo);
		model.addAttribute("upload", upload);
		
		return "upload/uploadview";
	}
	
	@RequestMapping(value = "download.action", method = RequestMethod.GET)
	public ModelAndView download(
		@RequestParam("uploadfileno") int uploadFileNo) {
		
		ModelAndView mav = new ModelAndView();
		
		UploadFile uploadFile = 
			dao.getUploadFileByUploadFileNo(uploadFileNo);
		mav.addObject("uploadfile", uploadFile);
		mav.setView(new DownloadView());
		
		return mav;
	}
	
	
}
