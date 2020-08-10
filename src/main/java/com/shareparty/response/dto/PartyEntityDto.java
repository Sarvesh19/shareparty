package com.shareparty.response.dto;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class PartyEntityDto {

	private Integer party_id;

	private String city;

	private String party_theme;

	private int total_participation;

	private Double per_head;

	private String party_start;

	private String party_end;

	private Double latitude;

	private Double Longitude;

	private Date party_date;

	private String description;

	private Long user_id;

	private String address;
	
	private String OrganizedBy;
	
	private String organizerContact;
	private String approxDist;

	public Integer getParty_id() {
		return party_id;
	}

	public void setParty_id(Integer party_id) {
		this.party_id = party_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getParty_theme() {
		return party_theme;
	}

	public void setParty_theme(String party_theme) {
		this.party_theme = party_theme;
	}

	public int getTotal_participation() {
		return total_participation;
	}

	public void setTotal_participation(int total_participation) {
		this.total_participation = total_participation;
	}

	public Double getPer_head() {
		return per_head;
	}

	public void setPer_head(Double per_head) {
		this.per_head = per_head;
	}

	public String getParty_start() {
		return party_start;
	}

	public void setParty_start(String party_start) {
		this.party_start = party_start;
	}

	public String getParty_end() {
		return party_end;
	}

	public void setParty_end(String party_end) {
		this.party_end = party_end;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Date getParty_date() {
		return party_date;
	}

	public void setParty_date(Date party_date) {
		this.party_date = party_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrganizedBy() {
		return OrganizedBy;
	}

	public void setOrganizedBy(String organizedBy) {
		OrganizedBy = organizedBy;
	}
	
	

	public String getOrganizerContact() {
		return organizerContact;
	}

	public void setOrganizerContact(String organizerContact) {
		this.organizerContact = organizerContact;
	}
	
	

	public String getApproxDist() {
		return approxDist;
	}

	public void setApproxDist(String approxDist) {
		this.approxDist = approxDist;
	}

	@Override
	public String toString() {
		return "PartyEntityDto [party_id=" + party_id + ", city=" + city + ", party_theme=" + party_theme
				+ ", total_participation=" + total_participation + ", per_head=" + per_head + ", party_start="
				+ party_start + ", party_end=" + party_end + ", latitude=" + latitude + ", Longitude=" + Longitude
				+ ", party_date=" + party_date + ", description=" + description + ", user_id=" + user_id + ", address="
				+ address + ", OrganizedBy=" + OrganizedBy + "]";
	}
	
	

}
