package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.HRMS.core.entities.UserCv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_account")
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String fistName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name = "nationality_id")
	@NotBlank
	@NotNull
	private String nationalityId;
	
	@Column(name = "date_of_birth")
	@NotNull
	private LocalDate dateOfBirth;
	
	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "verification")
	private boolean verification;

	@JsonIgnore
	@OneToMany(mappedBy = "userAccount")
	private List<UserCv> userCvs;
}
