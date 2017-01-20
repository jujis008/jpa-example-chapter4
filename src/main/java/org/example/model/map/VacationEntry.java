package org.example.model.map;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VacationEntry {

	@Temporal(TemporalType.DATE)
	@Column(name="inicio")
	private Calendar startDate;

	@Column(name="dias")
	private int daysTaken;

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public int getDaysTaken() {
		return daysTaken;
	}

	public void setDaysTaken(int daysTaken) {
		this.daysTaken = daysTaken;
	}



}
