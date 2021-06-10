package kodlamaio.HRMS.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.entities.dtos.CvAllDto;
import kodlamaio.HRMS.entities.dtos.UserCvEducationSortedDateDto;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

public interface UserCvDao extends JpaRepository<UserCv, Integer>{
	boolean existsByCvId(int cvId);
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto("
            + "uc.cvId, u.firstName, u.lastName, cje.workplaceName, cje.jobPositionName, cje.jobStartedDate, cje.jobQuitDate)"
            + "From UserAccount u Inner Join u.userCvs uc "
            + "Inner Join uc.cvJobExperiences cje ORDER BY cje.jobQuitDate DESC")
    List<UserCvJobExperienceSortedDateDto> getUserAccountWithUserCvWithCvJobExperienceSortedDate();
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.UserCvEducationSortedDateDto("
			+ "uc.cvId, u.firstName, u.lastName, ce.schoolName, ce.schoolSectionName, ce.startedDate, ce.dateOfGraduation)"
			+ "From UserAccount u Inner Join u.userCvs uc "
			+ "Inner Join uc.cvEducations ce ORDER BY ce.dateOfGraduation DESC")
	List<UserCvEducationSortedDateDto> getUserAccountWithUserCvWithCvEducationSortedDate();
	
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.CvAllDto("
			+ "uc.cvId, u.firstName, u.lastName, u.email, ce.schoolName, ce.schoolSectionName, "
			+ "cl.languageName, cl.languageLevel, cs.pLanguages, cs.pTechnology, cms.githubUrl, cms.linkedinUrl, ci.imageUrl)"
			+ "From UserAccount u Inner Join u.userCvs uc "
			+ "Inner Join uc.cvEducations ce "
			+ "Inner Join uc.cvLanguages cl "
			+ "Inner Join uc.cvSkills cs "
			+ "Inner Join uc.cvSocialMedias cms "
			+ "Inner Join uc.cvImages ci")
	List<CvAllDto> getAllCv();
}
