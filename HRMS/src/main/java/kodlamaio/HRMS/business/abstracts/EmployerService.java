package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.EmployerAccount;

public interface EmployerService {
	DataResult<List<EmployerAccount>> getAll();
	Result add(EmployerAccount employerAccount);

}
