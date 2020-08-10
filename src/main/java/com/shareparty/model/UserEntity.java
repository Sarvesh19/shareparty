package com.shareparty.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "tbl_user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer user_id;

	@Column(name = "user_firstname")
	private String firstName;

	@Column(name = "user_lastname")
	private String lastName;

	@Column(name = "user_rating")
	private Float userRating;

	
	@Column(name = "user_password")
	private String password;

	@Column(name = "user_city")
	private String user_city;

	@Column(name = "Email")
	private String email;

	@Column(name = "security1_ans")
	private String security1_ans;

	@Column(name = "security2_ans")
	private String security2_ans;
	
	@Column(name = "user_phoneNum")
	private String user_number;
	
	@Column(name = "user_img", length = 1000)
    private byte[] user_img;
	
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "user_country")
	private String user_country;
	
	@JsonManagedReference
	@OneToMany(targetEntity = PartyEntity.class,mappedBy = "userEntity", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<PartyEntity> partyEntityList = new HashSet<>();
	
	private String token;
	

	public UserEntity() {
		super();
	}

	public UserEntity(String firstName, String lastName, Float userRating, String password, String user_city,
			String email,String security1_ans,String security2_ans) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRating = userRating;
		this.password = password;
		this.user_city = user_city;
		this.email = email;
		this.security1_ans = security1_ans;
		this.security2_ans = security2_ans;

	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getUserRating() {
		return userRating;
	}

	public void setUserRating(Float userRating) {
		this.userRating = userRating;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurity1_ans() {
		return security1_ans;
	}

	public void setSecurity1_ans(String security1_ans) {
		this.security1_ans = security1_ans;
	}

	public String getSecurity2_ans() {
		return security2_ans;
	}

	public void setSecurity2_ans(String security2_ans) {
		this.security2_ans = security2_ans;
	}
	
	

	public String getUser_number() {
		return user_number;
	}

	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	
	

	public byte[] getUser_img() {
		return user_img;
	}

	public void setUser_img(byte[] user_img) {
		this.user_img = user_img;
	}

	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUser_country() {
		return user_country;
	}

	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	
	

	public Set<PartyEntity> getPartyEntityList() {
		return partyEntityList;
	}

	public void setPartyEntityList(Set<PartyEntity> partyEntityList) {
		this.partyEntityList = partyEntityList;
	}

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userRating=" + userRating + ", password=" + password + ", user_city=" + user_city + "]";
	}

}
