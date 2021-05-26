package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.EmployerAccount;

@Repository
public interface EmployerDao extends JpaRepository<EmployerAccount, Integer>{
	boolean existsByEmail(String email);
}
