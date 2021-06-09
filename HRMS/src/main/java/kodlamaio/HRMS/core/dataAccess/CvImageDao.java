package kodlamaio.HRMS.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.HRMS.core.entities.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>{
	@Modifying
	@Query("update CvImage set imageUrl =: imageUrl where userCv_cvId =: cvId")
	int updateCvImageSetImageUrlForUserCv_CvId(@Param("imageUrl") String imageUrl, @Param("cvId") int cvId);
}
