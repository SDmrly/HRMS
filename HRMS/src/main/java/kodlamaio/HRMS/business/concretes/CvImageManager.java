package kodlamaio.HRMS.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.Adapter.abstracts.CloudinaryService;
import kodlamaio.HRMS.business.abstracts.CvImageService;
import kodlamaio.HRMS.core.dataAccess.CvImageDao;
import kodlamaio.HRMS.core.dataAccess.UserCvDao;
import kodlamaio.HRMS.core.entities.CvImage;
import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

@Service
public class CvImageManager implements CvImageService{
	private CvImageDao cvImageDao;
	private UserCvDao userCvDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao, UserCvDao userCvDao, CloudinaryService cloudinaryService) {
		super();
		this.cvImageDao = cvImageDao;
		this.userCvDao = userCvDao;
		this.cloudinaryService = cloudinaryService;
	}


	@Override
	public Result addImage(UserCv userCv, CvImage cvImage, MultipartFile multipartFile) throws IOException {
		if(this.userCvDao.existsByCvId(userCv.getCvId()))
		{
			Map imageMap = cloudinaryService.ImageoUpload(multipartFile);
			cvImage.setImageUrl(imageMap.get("imageUrl").toString());
			this.cvImageDao.save(cvImage);
			return new SuccessResult("Resim eklendi.");
		}else {
			return new ErrorResult("Kayıtlı CV bulunamadı.");
		}
	}

}
