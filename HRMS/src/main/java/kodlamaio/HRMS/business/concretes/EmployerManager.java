package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.EmployerAccount;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}


	@Override
	public DataResult<List<EmployerAccount>> getAll() {
		return new SuccesDataResult<List<EmployerAccount>>(this.employerDao.findAll(), "İşverenler Listelendi.");
	}


	@Override
	public Result add(EmployerAccount employerAccount) {
		if(employerAccount.getCompanyName().isEmpty() || employerAccount.getWebsite().isEmpty()
				|| employerAccount.getEmail().isEmpty() || employerAccount.getTelephone().isEmpty()
				|| employerAccount.getPassword().isEmpty()) {
			return new ErrorResult("Lütfen bütün alanları doldurun.");
		}
		
		if(this.employerDao.existsByEmail(employerAccount.getEmail())) {
			return new ErrorResult("Mail adresi kullanımda.");
		}
		
		this.employerDao.save(employerAccount);
		return new SuccessResult("Yeni İşveren eklendi");
	}

}
