package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.HRMS.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;

@Service
public class JobAdvertManager implements JobAdvertService{
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		if(this.jobAdvertDao.existsByIsActiveted(true)) {
			return new SuccesDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "İlanlar Listelendi.");
		}
		return new ErrorDataResult<>("Aktif iş ilanı bulunmamakta.");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllDateSorted() {
		if(this.jobAdvertDao.existsByIsActiveted(true)) {
			Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");
			return new SuccesDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "Sıralama başarılı.");
		}
		return new ErrorDataResult<>("Aktif iş ilanı bulunmamakta.");
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerAccount(int employerId) {
		if(this.jobAdvertDao.existsByIsActiveted(true)) {
			return new SuccesDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByEmployerAccount(employerId), "Firmaya ait bütün data listelendi.");
		}
		return new ErrorDataResult<>("Firmaya ait aktif ilen bulunmamakta.");
	}

	@Override
	public Result updateJobAdvertSetIsActivetedForJobId(int jobId) {
		if(this.jobAdvertDao.existsByIsActiveted(false)) {
			return new ErrorResult("İş ilanı zaten pasif durumda.");
		}
		this.jobAdvertDao.updateJobAdvertSetIsActivetedForJobId(jobId);
		return new SuccessResult("İş ilanı pasif duruma getirildi.");
	}


	
}
