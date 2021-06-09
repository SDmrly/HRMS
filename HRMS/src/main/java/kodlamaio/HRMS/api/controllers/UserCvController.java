package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.UserCvService;
import kodlamaio.HRMS.core.entities.UserCv;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.dtos.UserCvJobExperienceSortedDateDto;

@RestController
@RequestMapping(value= "/api/usercv")
public class UserCvController {
	private UserCvService userCvService;

	@Autowired
	public UserCvController(UserCvService userCvService) {
		super();
		this.userCvService = userCvService;
	}
	
	@PostMapping(value = "/add")
	public Result add(UserCv userCv) {
		return this.userCvService.add(userCv);
	}
	
	@GetMapping(value = "/getAll")
	public DataResult<List<UserCv>> getAll(){
		return this.userCvService.getAll();
	}
	
	@GetMapping(value = "/getUserAccountWithUserCvWithCvJobExperienceSortedDate")
	public DataResult<List<UserCvJobExperienceSortedDateDto>> getUserAccountWithUserCvWithCvJobExperienceSortedDate(){
		return this.userCvService.getUserAccountWithUserCvWithCvJobExperienceSortedDate();
	}
	
	
}
