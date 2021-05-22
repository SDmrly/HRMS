package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobPositions;

public interface JobPositionsService {
	List<JobPositions> getAll();
}
