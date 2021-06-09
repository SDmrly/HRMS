package kodlamaio.HRMS.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.entities.CvImage;
import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.Result;

public interface CvImageService {
	Result addImage(UserCv userCv, CvImage cvImage, MultipartFile multipartFile) throws IOException;
}
