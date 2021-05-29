package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.UserAccount;

@Repository
public interface UserDao extends JpaRepository<UserAccount, Integer>{
	boolean existsByEmailOrNationalityId(String email, String nationalityId);
}
