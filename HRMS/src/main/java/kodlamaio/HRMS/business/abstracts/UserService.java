package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.UserAccount;

public interface UserService {
	DataResult<List<UserAccount>> getAll();
	Result add(UserAccount userAccount);
}
