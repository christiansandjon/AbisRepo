package be.abis.casebce.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WorkingDay")
public class WorkingDay implements Serializable {

	@Id
	@SequenceGenerator(name = "WorkingDay_Gen", sequenceName = "WorkingDay_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WorkingDay_Gen")
	@Column(name = "id")
	private int id;
	@Column(name = "start_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime start;
	@Column(name = "end_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime end;

	@ManyToOne
	@JoinColumn(name = "workerid")
	private ExternalWorker worker;

	// constructor
	public WorkingDay() {
	}

	// getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public ExternalWorker getWorker() {
		return worker;
	}

	public void setWorker(ExternalWorker worker) {
		this.worker = worker;
	}
}
