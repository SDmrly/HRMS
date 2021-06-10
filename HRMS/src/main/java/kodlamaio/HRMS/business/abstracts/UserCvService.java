package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.dtos.CvAllDto;
import kodlamaio.HRMS.entities.dtos.UserCvEducationSortedDateDto;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

public interface UserCvService {
	Result add(UserCv userCv);
	DataResult<List<UserCvJobExperienceSortedDateDto>> getUserAccountWithUserCvWithCvJobExperienceSortedDate();
	DataResult<List<UserCvEducationSortedDateDto>> getUserAccountWithUserCvWithCvEducationSortedDate();
	DataResult<List<CvAllDto>> getAllCv();
}
