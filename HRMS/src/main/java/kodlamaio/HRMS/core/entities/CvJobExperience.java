package kodlamaio.HRMS.core.entities;

import java.time.LocalDate;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user_cvs"})
public class CvJobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_experience_id")
	private int cvExperienceId;
	
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@Column(name = "job_position_name")
	private String jobPositionName;
	
	@Column(name = "job_started_date")
	private LocalDate jobStartedDate;
	
	@Column(name = "job_quit_date")
	private LocalDate jobQuitDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private UserCv userCv;

}
