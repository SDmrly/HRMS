package kodlamaio.HRMS.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getAllDateSorted")
	public DataResult<List<JobAdvert>> getAllDateSorted(){
		return this.jobAdvertService.getAllDateSorted();
	}
	
	@GetMapping("/getJobAdvertByEmployerAccount")
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerAccount(@RequestParam("employerId") int employerId) {
		return this.jobAdvertService.getJobAdvertByEmployerAccount(employerId);
	}
	
	@GetMapping("/updateDeactiveted")
	@Transactional
	public Result updateJobAdvertSetIsActivetedForJobId(@RequestParam("jobId") int jobId) {
		return this.jobAdvertService.updateJobAdvertSetIsActivetedForJobId(jobId);
	}


}
