package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobPositionsService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPositions);
	
	
}
