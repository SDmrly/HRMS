package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.HRMS.business.abstracts.UserCvService;
import kodlamaio.HRMS.core.dataAccess.UserCvDao;
import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

@Service
public class UserCvManager  implements UserCvService{
	private UserCvDao userCvDao;

	@Autowired
	public UserCvManager(UserCvDao userCvDao) {
		super();
		this.userCvDao = userCvDao;
	}

	@Override
	public Result add(@RequestBody UserCv userCv) {
		this.userCvDao.save(userCv);
		return new SuccessResult("CV eklendi.");
	}

	@Override
	public DataResult<List<UserCv>> getAll() {
		return new SuccesDataResult<List<UserCv>>(this.userCvDao.findAll(), "Cv Listelendi.");
	}

	@Override
	public DataResult<List<UserCvJobExperienceSortedDateDto>> getUserAccountWithUserCvWithCvJobExperienceSortedDate() {
		return new SuccesDataResult<List<UserCvJobExperienceSortedDateDto>>(this.userCvDao.getUserAccountWithUserCvWithCvJobExperienceSortedDate(), "Data Listelendi.");
	}
}
