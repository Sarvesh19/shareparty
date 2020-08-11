package com.shareparty.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shareparty.model.PartyEntity;
import com.shareparty.model.UserEntity;

@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, Integer>{
	
	
	@Query(value = "SELECT * FROM tbl_party u WHERE  u.party_date >= :startDate and u.party_date <= :endDate and u.user_id <> :currentUserID"  
			+ "", 
			  nativeQuery = true)
	List<PartyEntity> findPartyNative(
			   @Param("startDate") String startDate,@Param("endDate") String endDate,@Param("currentUserID") int currentUserID);
	
	@Query(value = "SELECT * FROM tbl_party u WHERE u.party_date = :startDate and u.user_id <> :currentUserID"  
			+ "", 
			  nativeQuery = true)
	List<PartyEntity> findPartyByOneDayNative(
			  @Param("startDate") String startDate,@Param("currentUserID") int currentUserID); 
	
//@Param("city") String city,
}
