package com.shareparty.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareparty.exception.EmailExistsException;
import com.shareparty.exception.RecordNotFoundException;
import com.shareparty.model.ForgotPassword;
import com.shareparty.model.PartyEntity;
import com.shareparty.model.UserEntity;
import com.shareparty.model.UserNamePassword;
import com.shareparty.repository.PartyRepository;
import com.shareparty.repository.UserRepository;
import com.shareparty.response.dto.CreatePartyDto;
import com.shareparty.response.dto.PartyEntityDto;
import com.shareparty.response.dto.SearchPartyDto;
import com.shareparty.security.AES;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private AES aes;
	
//	@Autowired
//	private PartyEntityDto partyEntityDto;

	@Transactional(readOnly = true)
	public UserEntity getEmployeeById(Integer id) throws RecordNotFoundException {
		Optional<UserEntity> user = userRepository.findById(id);

		if (user.isPresent()) {

			return user.get();

		} else {
			throw new RecordNotFoundException("No User record exist for given id");
		}
	}

	public UserEntity loginUser(UserNamePassword val) throws RecordNotFoundException {

		Optional<UserEntity> user = userRepository.findEmployeeByUserNameNative(val.getUsername());

		if (user.isPresent() && userPasswordCheck(val.getPassword(), user.get())) {
			return user.get();
		} else {
			throw new RecordNotFoundException("No User record exist for given username");

		}

	}

	public boolean userPasswordCheck(String password, UserEntity user) {

		// PasswordEncoder passencoder = new BCryptPasswordEncoder();
		String encodedPassword = user.getPassword();
		return passwordEncoder.matches(password, encodedPassword);
	}

	public UserEntity registerNewUserAccount(UserEntity userDto) throws EmailExistsException {
		if (emailExist(userDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress:" + userDto.getEmail());
		}
		UserEntity user = new UserEntity();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());

		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setSecurity1_ans(passwordEncoder.encode(userDto.getSecurity1_ans()));
		user.setSecurity2_ans(passwordEncoder.encode(userDto.getSecurity2_ans()));
		user.setUser_city(userDto.getUser_city());
		user.setUserRating(5f);

		user.setEmail(userDto.getEmail());
		return userRepository.save(user);
	}

	private boolean emailExist(String email) {
		// logic if email present

		return (userRepository.isEmailPresentNative(email)) == 0 ? false : true;

	}

	public UserEntity forgotPasswordUser(ForgotPassword passUser) throws EmailExistsException, RecordNotFoundException {
		UserEntity userEntity = null;
		if (!emailExist(passUser.getEmail())) {
			throw new EmailExistsException("There is no account with this email adress:" + passUser.getEmail());
		}
		Optional<UserEntity> user = userRepository.findEmployeeByUserNameNative(passUser.getEmail());
		if (user.isPresent()) {
			userEntity = user.get();
		}

		if (passwordEncoder.matches(passUser.getSecurityAns1(), userEntity.getSecurity1_ans())
				&& passwordEncoder.matches(passUser.getSecurityAns2(), userEntity.getSecurity2_ans())) {
			userEntity.setPassword(passwordEncoder.encode(passUser.getPassword()));
			userRepository.save(userEntity);
			return userEntity;
		} else {
			throw new RecordNotFoundException("No User record exist for given id");
		}

	}

	public UserEntity loadUserByUsernameUpload(String username, byte[] image) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findEmployeeByUserNameNative(username);
		UserEntity userEntity = null;
		if (user.isPresent()) {
			userEntity = user.get();
		}
		userEntity.setUser_img(image);
		userRepository.save(userEntity);

		return userEntity;
	}

	public UserEntity loadUser(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findEmployeeByUserNameNative(username);
//		Optional<UserEntity> user1 = userRepository.findById(user.get().getUser_id());
//		System.out.println(user1);
		UserEntity userEntity = null;
		if (user.isPresent()) {
			userEntity = user.get();
		}
		userRepository.save(userEntity);

		return userEntity;
	}

	public PartyEntity createParty(CreatePartyDto dto, Long id) throws UsernameNotFoundException {

		PartyEntity partyEntity = new PartyEntity();
		partyEntity.setAddress(dto.getAddress());
		partyEntity.setCity(dto.getCity());
		partyEntity.setDescription(dto.getDescription());
		partyEntity.setLatitude(dto.getLatitude());
		partyEntity.setLongitude(dto.getLongitude());
		partyEntity.setUser_id(id);
		partyEntity.setParty_date(dto.getParty_date());
		partyEntity.setParty_end(dto.getParty_end());
		partyEntity.setParty_start(dto.getParty_start());
		partyEntity.setParty_theme(dto.getParty_theme());
		partyEntity.setPer_head(new Double(dto.getPer_head()));
		partyEntity.setTotal_participation(dto.getTotal_participation());
//		Optional<UserEntity> user = userRepository.findEmployeeByUserNameNative(username);
//		UserEntity userEntity = null;
//		if (user.isPresent()) {
//			userEntity = user.get();
//		}
		partyRepository.save(partyEntity);

		return partyEntity;
	}

	public List<PartyEntityDto> searchParty(SearchPartyDto searchDto, UserEntity user) {
		String start = null;
		String end = null;
		if (null != searchDto.getStartDate()) {
			start = new SimpleDateFormat("yyyy-MM-dd").format(searchDto.getStartDate());

		}
		if (null != searchDto.getEndDate()) {
			end = new SimpleDateFormat("yyyy-MM-dd").format(searchDto.getEndDate());

		}

		List<PartyEntity> partyEntityList = null;
		if (start.equals(end) || (start != null && end == null)) {
			partyEntityList = partyRepository.findPartyByOneDayNative(start,user.getUser_id());

		} else {
			partyEntityList = partyRepository.findPartyNative( start, end,user.getUser_id());

		}
		List<PartyEntityDto> searchedPartyList = new ArrayList<>();
		if (!partyEntityList.isEmpty()) {
		for (PartyEntity partyEntity : partyEntityList) {
			double distanceBtn= distance(searchDto.getLatitude(),partyEntity.getLatitude(),searchDto.getLongitude(),partyEntity.getLongitude());
			if(distanceBtn <=searchDto.getDistance()) {
				PartyEntityDto partyEntityDto  = new PartyEntityDto();
				partyEntityDto.setAddress(partyEntity.getAddress());
				partyEntityDto.setCity(partyEntity.getCity());
				partyEntityDto.setOrganizedBy(partyEntity.getUserEntity().getFirstName() + " "+ partyEntity.getUserEntity().getLastName());
				partyEntityDto.setLatitude(partyEntity.getLongitude());
				partyEntityDto.setLongitude(partyEntity.getLatitude());
				partyEntityDto.setParty_date(partyEntity.getParty_date());
				partyEntityDto.setDescription(partyEntity.getDescription());
				partyEntityDto.setParty_start(partyEntity.getParty_start());
				partyEntityDto.setParty_end(partyEntity.getParty_end());
				partyEntityDto.setParty_theme(partyEntity.getParty_theme());
				partyEntityDto.setTotal_participation(partyEntity.getTotal_participation());
				partyEntityDto.setPer_head(partyEntity.getPer_head());
				partyEntityDto.setOrganizerContact(partyEntity.getUserEntity().getEmail());
				partyEntityDto.setApproxDist(String.valueOf(distanceBtn));
				
				searchedPartyList.add(partyEntityDto);
			}
			
		}
			
			
			
			return searchedPartyList;
		}
		return null;

	}

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

// The math module contains a function 
// named toRadians which converts from 
// degrees to radians. 
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

// Haversine formula  
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

// Radius of earth in kilometers. Use 3956  
// for miles 
		double r = 6371;

// calculate the result 
		return Math.round(c * r);
	}

}
