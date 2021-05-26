package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPositionsService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMS.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionsManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccesDataResult<List<JobPositions>>(this.jobPositionDao.findAll()
				, "Pozisyonlar Listelendi.");
	}

	@Override
	public Result add(JobPositions jobPositions) {
		if(this.jobPositionDao.existsByPositionName(jobPositions.getPositionName())) {
			return new ErrorResult("Pozisyon Mevcut");
		}
		this.jobPositionDao.save(jobPositions);
		return new SuccessResult("Pozisyon Eklendi.");
	}

}
