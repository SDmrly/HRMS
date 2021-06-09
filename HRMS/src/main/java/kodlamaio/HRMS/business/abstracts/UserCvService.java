package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

public interface UserCvService {
	Result add(UserCv userCv);
	DataResult<List<UserCv>> getAll();
	DataResult<List<UserCvJobExperienceSortedDateDto>> getUserAccountWithUserCvWithCvJobExperienceSortedDate();

}
