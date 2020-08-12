package com.shareparty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shareparty.model.PartyEntity;
import com.shareparty.model.PartyRequestEntity;

@Repository
public interface RequestPartyRepository extends JpaRepository<PartyRequestEntity, Integer>{
	
	
	@Query(value = "SELECT * FROM tbl_party_request u WHERE u.from_req_id = :fromUser and u.party_id = :partyId"  
			+ "", 
			  nativeQuery = true)
	Object isRequestedNative(
			  @Param("fromUser") int fromUser, @Param("partyId") int partyId); 
	
	
	@Query(value = "SELECT * FROM tbl_party_request u WHERE u.from_req_id = :fromUser and u.party_id = :partyId"  
			+ "", 
			  nativeQuery = true)
	PartyEntity requestPartyNative(
			  @Param("fromUser") int fromUser, @Param("partyId") int partyId); 

}

