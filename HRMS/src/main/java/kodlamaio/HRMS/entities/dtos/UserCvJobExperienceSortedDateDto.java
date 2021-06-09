package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvJobExperienceSortedDateDto {
	private int cvId;
	private String firstName;
	private String lastName;
	private LocalDate jobStartedDate;
	private LocalDate jobQuitDate;
	

}
