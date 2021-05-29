package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private int jobId;
	
	@Column(name = "position_count")
	private int positionCount;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "release_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate releaseDate = LocalDate.now();
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "is_activeted")
	private boolean isActiveted;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private EmployerAccount employerAccount;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;
	
	

}
