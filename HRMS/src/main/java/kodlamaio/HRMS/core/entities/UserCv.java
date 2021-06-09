package kodlamaio.HRMS.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import kodlamaio.HRMS.entities.concretes.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_cvs")
public class UserCv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private UserAccount userAccount;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvEducation> cvEducations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvJobExperience> cvJobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvLanguage> cvLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvSocialMedia> cvSocialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvSkill> cvSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userCv")
	private List<CvImage> cvImages;

	

}
