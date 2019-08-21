package com.atmecs.helper;

/**
 * @category POJO Class
 * @author Sandhiya.Munisamy
 *
 */
public class LoginData {
	public String Email;
	public String Password;
	

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

	@Override
	public String toString() {
		return "LoginData [Email=" + Email + ", Password=" + Password + "]";
	}

}
