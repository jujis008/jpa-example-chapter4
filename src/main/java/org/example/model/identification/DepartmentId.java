package org.example.model.identification;

import java.io.Serializable;

public class DepartmentId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private int number;

	public DepartmentId() {
	}

	public DepartmentId(int id, int number) {
		this.id = id;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentId other = (DepartmentId) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

}
