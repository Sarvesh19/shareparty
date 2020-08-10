package com.shareparty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shareparty.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	
	@Query(value = "SELECT * FROM tbl_user u WHERE u.id = :id", 
			  nativeQuery = true)
	Optional<UserEntity> findEmployeeByIdNative(
			  @Param("id") Long id);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_user t WHERE t.Email = :email",    
			  nativeQuery = true)
	int isEmailPresentNative(
			  @Param("email") String email);
	
	@Query(value = "SELECT * FROM tbl_user u WHERE u.Email = :username", 
			  nativeQuery = true)
	Optional<UserEntity> findEmployeeByUserNameNative(
			  @Param("username") String username);
	
	// SELECT COUNT(*) FROM tbl_user t WHERE t.Email = :email;

 
}