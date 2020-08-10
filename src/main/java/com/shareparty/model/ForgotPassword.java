package com.shareparty.model;

public class ForgotPassword {

	private String password;

	private String securityAns1;

	private String securityAns2;
	
	private String email;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAns1() {
		return securityAns1;
	}

	public void setSecurityAns1(String securityAns1) {
		this.securityAns1 = securityAns1;
	}

	public String getSecurityAns2() {
		return securityAns2;
	}

	public void setSecurityAns2(String securityAns2) {
		this.securityAns2 = securityAns2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
