package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.JobPositions;

@Repository
public interface JobPositionDao extends JpaRepository<JobPositions, Integer> {
	
	boolean existsByPositionName(String positionName);
}
