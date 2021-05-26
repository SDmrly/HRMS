package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPositions;

public interface JobPositionsService {
	DataResult<List<JobPositions>> getAll();
	Result add(JobPositions jobPositions);
	
	
}
