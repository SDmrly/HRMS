package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "job_positions")
public class JobPositions {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "position_id")
	private int positionId;
	
	@Column(name = "position_name")
	private String positionName;
	
	public JobPositions() {}
	
	public JobPositions(int id, int positionId, String positionName) {
		super();
		this.id = id;
		this.positionId = positionId;
		this.positionName = positionName;
	}
	
}
