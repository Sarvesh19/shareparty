package com.shareparty.response.dto;

import java.util.Date;

public class CreatePartyDto {
	private String address;
	private String description;
	private Double latitude;
	private Double longitude;
	private Date party_date;
	private String party_start;
	private String party_end;
	private String party_theme;
	private Float per_head;
	private Integer total_participation;
	private String username;
	private String city;
	
	
	
	

	public CreatePartyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreatePartyDto(String address, String description, Double latitude, Double longitude, Date party_date,
			String party_start, String party_end, String party_theme, Float per_head, Integer total_participation) {
		super();
		this.address = address;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.party_date = party_date;
		this.party_start = party_start;
		this.party_end = party_end;
		this.party_theme = party_theme;
		this.per_head = per_head;
		this.total_participation = total_participation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getParty_date() {
		return party_date;
	}

	public void setParty_date(Date party_date) {
		this.party_date = party_date;
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

	public String getParty_theme() {
		return party_theme;
	}

	public void setParty_theme(String party_theme) {
		this.party_theme = party_theme;
	}

	public Float getPer_head() {
		return per_head;
	}

	public void setPer_head(Float per_head) {
		this.per_head = per_head;
	}

	public Integer getTotal_participation() {
		return total_participation;
	}

	public void setTotal_participation(Integer total_participation) {
		this.total_participation = total_participation;
	}
	
	
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CreatePartyDto [address=" + address + ", description=" + description + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", party_date=" + party_date + ", party_start=" + party_start
				+ ", party_end=" + party_end + ", party_theme=" + party_theme + ", per_head=" + per_head
				+ ", total_participation=" + total_participation + "]";
	}
	
	

}
