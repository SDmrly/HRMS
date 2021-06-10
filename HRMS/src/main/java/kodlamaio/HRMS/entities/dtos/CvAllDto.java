package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvAllDto {
	private int cvId;
	private String firstName;
	private String lastName;
	private String email;
	private String schoolName;
	private String schoolSectionName;
	private String languageName;
	private int languageLevel;
	private String pLanguages;
	private String pTechnology;
	private String githubUrl;
	private String linkedinUrl;
	private String imageUrl;
	
	

}
