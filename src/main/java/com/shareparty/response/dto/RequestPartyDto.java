package com.shareparty.response.dto;


public class RequestPartyDto {
	
	private Boolean status;

	private int party_id;

	private int user_id;
	
	private String username;
	
	
	private Integer from_req_id;
	
	private String message;

	public RequestPartyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getParty_id() {
		return party_id;
	}

	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Integer getFrom_req_id() {
		return from_req_id;
	}

	public void setFrom_req_id(Integer from_req_id) {
		this.from_req_id = from_req_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "RequestPartyDto [status=" + status + ", party_id=" + party_id + ", user_id=" + user_id
				+ ", from_req_id=" + from_req_id + ", message=" + message + "]";
	}
	
	
	

}
