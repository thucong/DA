package model;

import java.io.Serializable;

public class SubjectModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4825032294158445240L;
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
