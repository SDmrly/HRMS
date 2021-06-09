package kodlamaio.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer_account")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvert"})
public class EmployerAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name = "email")
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name = "telephone")
	@NotBlank
	@NotNull
	private String telephone;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "verification")
	private boolean verification;
	
	@Column(name = "hrms_verification")
	private boolean hrmsVerification;

	@OneToMany(mappedBy = "employerAccount")
	private List<JobAdvert> jobAdvert;

}
