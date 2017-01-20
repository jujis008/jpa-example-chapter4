package org.example.model.ordercolumn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class PrintQueue {

	public PrintQueue() {
		jobs = new ArrayList<PrintJob>();
	}

	@Id
	@GeneratedValue
	private int id;

	@OneToMany(mappedBy = "queue", cascade=CascadeType.PERSIST)
	@OrderColumn(name = "PRINT_ORDER")
	private List<PrintJob> jobs;

	public List<PrintJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<PrintJob> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "PrintQueue [id=" + id + ", jobs=" + jobs + "]";
	}

}
