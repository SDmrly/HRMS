package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employer_account")
public class EmployerAccount {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "verification")
	private boolean verification;
	
	@Column(name = "hrms_verification")
	private boolean hrmsVerification;
	
	public EmployerAccount(int id, String companyName, String website, String email, String telephone, String password,
			boolean verification, boolean hrmsVerification) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.verification = verification;
		this.hrmsVerification = hrmsVerification;
	}
	
	
}
