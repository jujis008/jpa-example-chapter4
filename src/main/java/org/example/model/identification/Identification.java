package org.example.model.identification;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public abstract class Identification implements Serializable {

	private static final long serialVersionUID = -9073170373995511408L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
