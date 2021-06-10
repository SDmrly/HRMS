package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvEducationSortedDateDto {
	private int cvId;
	private String firstName;
	private String lastName;
	private String schoolName;
	private String schoolSectionName;
	private LocalDate startedDate;
	private LocalDate dateOfGraduation;
	
}
