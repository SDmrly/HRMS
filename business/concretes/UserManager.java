package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.Adapter.abstracts.MernisService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.UserAccount;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	private MernisService mernisService;
	
	@Autowired
	public UserManager(UserDao userDao, MernisService mernisService) {
		super();
		this.userDao = userDao;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<UserAccount>> getAll() {
		return new SuccesDataResult<List<UserAccount>>(this.userDao.findAll(), "Kullanıcılar Listelendi.");
	}

	@Override
	public Result add(UserAccount userAccount) {
		if(userAccount.getFistName().isEmpty() || userAccount.getLastName().isEmpty() || userAccount.getNationalityId().isEmpty()
				|| String.valueOf(userAccount.getDateOfBirth()).isEmpty() || userAccount.getEmail().isEmpty()
				|| userAccount.getPassword().isEmpty()) {
			return new ErrorResult("Lütfen bütün alanları doldurun!");
		}
		
		if(this.userDao.existsByEmailOrNationalityId(userAccount.getEmail(), userAccount.getNationalityId())) {
			return new ErrorResult("TC no ve ya email kullanımda.");
		}
		
		if(mernisService.checkIfRealPerson(userAccount)) {
			
			this.userDao.save(userAccount);
			return new SuccessResult("Yeni Kullanıcı Eklendi.");
			
		}else {
			return new ErrorResult("Lütfen bilgilerini kontrol et.");
		}
			
	}
	
}
