package kodlamaio.HRMS.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

public interface UserCvDao extends JpaRepository<UserCv, Integer>{
	boolean existsByCvId(int cvId);
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto("
			+ "c.cvId, u.firstName, u.lastName, j.jobStartedDate, j.jobQuitDate)"
			+ "From UserAccount u Inner Join u.userCvs c"
			+ "Inner Join c.cvJobExperiences j")
	List<UserCvJobExperienceSortedDateDto> getUserAccountWithUserCvWithCvJobExperienceSortedDate();
}
