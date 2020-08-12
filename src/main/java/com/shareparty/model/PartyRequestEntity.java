package com.shareparty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_party_request")
public class PartyRequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "party_request_id", unique = true, nullable = false)
	private Integer party_request_id;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "party_id")
	private int party_id;

	@Column(name = "user_id")
	private int user_id;
	
	
	@Column(name = "from_req_id")
	private Integer from_req_id;
	
	@Column(name = "message")
	private String message;
	
	

	public PartyRequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartyRequestEntity(Boolean status, int party_id, int user_id) {
		super();
		this.status = status;
		this.party_id = party_id;
		this.user_id = user_id;
	}

	public Integer getParty_request_id() {
		return party_request_id;
	}

	public void setParty_request_id(Integer party_request_id) {
		this.party_request_id = party_request_id;
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

	@Override
	public String toString() {
		return "PartyRequestEntity [party_request_id=" + party_request_id + ", status=" + status + ", party_id="
				+ party_id + ", user_id=" + user_id + "]";
	}

}
