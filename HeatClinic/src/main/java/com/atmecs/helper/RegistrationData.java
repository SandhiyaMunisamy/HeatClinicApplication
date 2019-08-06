package com.atmecs.helper;

public class RegistrationData {
	String Email;
	String FirstName;
	String LastName;
	String Password;
	String ConfirmPassword;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegistrationData [Email=" + Email + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Password=" + Password + ", ConfirmPassword=" + ConfirmPassword + "]";
	}

}
