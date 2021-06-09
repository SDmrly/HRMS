package kodlamaio.HRMS.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user_cvs"})
public class CvEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_education_id")
	private int cvEducationId;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "school_section_name")
	private String schoolSectionName;
	
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private UserCv userCv;

}
