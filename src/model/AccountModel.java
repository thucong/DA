package model;

import java.io.Serializable;

public class AccountModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id_user;
	private String username;
	private String password;
	private String role;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRole(){
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id_user;
	}

	public void setId(Long id_user) {
		this.id_user = id_user;
	}

	
}
