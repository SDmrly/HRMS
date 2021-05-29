package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.JobAdvert;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	boolean existsByIsActiveted(boolean isActiveted);
	
	@Query("From JobAdvert where employer_id =:employerId")
	List<JobAdvert> getJobAdvertByEmployerAccount(int employerId);
	
	@Modifying
	@Query("Update JobAdvert set isActiveted = false where jobId=:jobId")
	int updateJobAdvertSetIsActivetedForJobId(@Param("jobId") int jobId);
	
}
