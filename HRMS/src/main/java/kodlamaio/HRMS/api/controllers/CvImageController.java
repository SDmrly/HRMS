package kodlamaio.HRMS.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.CvImageService;
import kodlamaio.HRMS.core.entities.CvImage;
import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.Result;

@RestController
@RequestMapping(value = "/api/cvimage")
public class CvImageController {
	private CvImageService cvImageService;

	@Autowired
	public CvImageController(CvImageService cvImageService) {
		super();
		this.cvImageService = cvImageService;
	}
	
	@PostMapping(value = "/imageadd")
	Result addImage(@RequestBody UserCv userCv, @RequestBody CvImage cvImage, MultipartFile multipartFile) throws IOException{
		return this.cvImageService.addImage(userCv, cvImage, multipartFile);
		
	}
	
	
	

}
