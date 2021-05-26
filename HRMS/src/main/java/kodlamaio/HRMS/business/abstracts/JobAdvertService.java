package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAllDateSorted();
	
	DataResult<List<JobAdvert>> getJobAdvertByEmployerAccount(int employerId);
	
	Result updateJobAdvertSetIsActivetedForJobId(int jobId);
}
