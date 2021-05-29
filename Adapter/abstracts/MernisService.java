package kodlamaio.HRMS.Adapter.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.entities.concretes.UserAccount;

@Service
public interface MernisService {
	public boolean checkIfRealPerson(UserAccount userAccount);
}
