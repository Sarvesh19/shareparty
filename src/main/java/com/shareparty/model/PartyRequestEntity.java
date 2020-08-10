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
	private Long party_id;

	@Column(name = "user_id")
	private Long user_id;

	public PartyRequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartyRequestEntity(Boolean status, Long party_id, Long user_id) {
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

	public Long getParty_id() {
		return party_id;
	}

	public void setParty_id(Long party_id) {
		this.party_id = party_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "PartyRequestEntity [party_request_id=" + party_request_id + ", status=" + status + ", party_id="
				+ party_id + ", user_id=" + user_id + "]";
	}

}
