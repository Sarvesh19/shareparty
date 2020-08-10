package com.shareparty.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "tbl_party")
public class PartyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "party_id", unique = true, nullable = false)
	private Integer party_id;

	@Column(name = "city")
	private String city;

	@Column(name = "party_theme")
	private String party_theme;

	@Column(name = "total_participation")
	private int total_participation;

	@Column(name = "per_head")
	private Double per_head;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "party_start")
	private String party_start;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "party_end")
	private String party_end;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "Longitude")
	private Double Longitude;

	@Column(name = "party_date")
	private Date party_date;

	@Column(name = "description")
	private String description;

	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "address")
	private String address;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "user_id", insertable = false, updatable = false)    
	private UserEntity userEntity;
	
	@OneToMany
	private Set<PartyRequestEntity> PartyRequestEntity;
	

	public PartyEntity() {
		super();
	}

	public PartyEntity(String city, String party_theme, int total_participation, Double per_head, String party_start,
			String party_end, Double latitude, Double longitude, Date party_date, String description, Long organizer_id) {
		super();
		this.city = city;
		this.party_theme = party_theme;
		this.total_participation = total_participation;
		this.per_head = per_head;
		this.party_start = party_start;
		this.party_end = party_end;
		this.latitude = latitude;
		Longitude = longitude;
		this.party_date = party_date;
		this.description = description;
		this.user_id = organizer_id;
	}

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

	public Set<PartyRequestEntity> getPartyRequestEntity() {
		return PartyRequestEntity;
	}

	public void setPartyRequestEntity(Set<PartyRequestEntity> partyRequestEntity) {
		PartyRequestEntity = partyRequestEntity;
	}
	
	

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "PartyEntity [party_id=" + party_id + ", city=" + city + ", party_theme=" + party_theme
				+ ", total_participation=" + total_participation + ", per_head=" + per_head + ", party_start="
				+ party_start + ", party_end=" + party_end + ", latitude=" + latitude + ", Longitude=" + Longitude
				+ ", party_date=" + party_date + ", description=" + description + ", organizer_id=" + user_id
				+ "]";
	}
	
	

}
