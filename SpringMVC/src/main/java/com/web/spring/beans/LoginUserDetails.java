package com.web.spring.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoginUserDetails")
public class LoginUserDetails {

	private String firstName;
	private String lastName;
	private String email;
	private String oldPassword;
	private String newPassword;
//	private Set<ImageUpload> userImages = new HashSet<ImageUpload>();
	
	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Id
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "oldpassword")
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "UserImages", joinColumns={@JoinColumn(name = "id")} , inverseJoinColumns={@JoinColumn(name = "IMAGE_ID") })
	@Column(name="images")
	public Set<ImageUpload> getUserImages() {
		return userImages;
	}
	
	public void setUserImages(Set<ImageUpload> userImages) {
		this.userImages = userImages;
	}*/
	
	
}
