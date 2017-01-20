package org.example.model.ordercolumn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrintJob {


	private static int sequencia = 1;

	public PrintJob() {
		this.setOrdem(sequencia);
		sequencia++;
	}


	@Id
	@GeneratedValue
	private int id;

	private int ordem;

	@ManyToOne
	private PrintQueue queue;


	@Override
	public String toString() {
		return "PrintJob [id=" + id + ", ordem=" + ordem + ", queue=" + queue
				+ "]";
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
}
