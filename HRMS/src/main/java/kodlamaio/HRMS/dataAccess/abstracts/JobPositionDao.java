package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPositions;

public interface JobPositionDao extends JpaRepository<JobPositions, Integer> {

}
