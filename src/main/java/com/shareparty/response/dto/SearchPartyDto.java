package com.shareparty.response.dto;

import java.util.Date;

public class SearchPartyDto {

	private Date startDate;
	private Date endDate;
	private Double latitude;
	private Double longitude;
	private int distance;
	private String username;

	public SearchPartyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SearchPartyDto [startDate=" + startDate + ", endDate=" + endDate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", distance=" + distance + "]";
	}

}
