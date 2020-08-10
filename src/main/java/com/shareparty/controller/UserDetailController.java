package com.shareparty.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.shareparty.configuration.JwtUtil;
import com.shareparty.exception.EmailExistsException;
import com.shareparty.exception.RecordNotFoundException;
import com.shareparty.model.ForgotPassword;
import com.shareparty.model.PartyEntity;
import com.shareparty.model.UserEntity;
import com.shareparty.model.UserNamePassword;
import com.shareparty.response.dto.CreatePartyDto;
import com.shareparty.response.dto.PartyEntityDto;
import com.shareparty.response.dto.SearchPartyDto;
import com.shareparty.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserDetailController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;  
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "user", produces = "application/json")
	public ResponseEntity<UserEntity> getUser(@RequestParam("id") Integer id) throws RecordNotFoundException {

		UserEntity entity = userService.getEmployeeById(id);

		return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}
//	@CrossOrigin
	@GetMapping("/test")
	public JsonNode welcome() {
		String uri = "https://countries-cities.p.rapidapi.com/location/country/list";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-host", "countries-cities.p.rapidapi.com");
		headers.set("x-rapidapi-key", "85ca4a6493msh2c8a2643bb783fap18555djsnc1f6ad316514");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.add("format", "json");
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<JsonNode> rest  = restTemplate.exchange(uri, HttpMethod.GET,entity, JsonNode.class);
		
		return rest.getBody();
	}

	@PostMapping(path = "registeruser", consumes = "application/json", produces = "application/json")

	public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity userDto) throws Exception {

		UserEntity user = userService.registerNewUserAccount(userDto);

		if (user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", new Exception());
		}

		String token = jwtUtil.generateToken(user.getEmail());
		user.setToken(token);

		return new ResponseEntity<UserEntity>(user, new HttpHeaders(), HttpStatus.OK);

	}
	
	
	

	@PostMapping(path = "loginuser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserEntity> loginUser(@RequestBody UserNamePassword userDto)
			throws Exception {

		UserEntity user = userService.loginUser(userDto);

		String token = jwtUtil.generateToken(user.getEmail());
		user.setToken(token);
		return new ResponseEntity<UserEntity>(user, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping(path = "forgotpassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserEntity> forgotPassword(@RequestBody ForgotPassword userDto)
			throws Exception {

		UserEntity userEntity = userService.forgotPasswordUser(userDto);
		String token = jwtUtil.generateToken(userEntity.getEmail());
		userEntity.setToken(token);
		return new ResponseEntity<UserEntity>(userEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(path = "userdetail", produces = "application/json")

	public ResponseEntity<UserEntity> registerUser(@RequestBody String username) throws Exception {

		UserEntity user = userService.loadUser(username);
		if(user.getUser_img() != null) {
			byte[] decompressImg = decompressBytes(user.getUser_img());
			user.setUser_img(decompressImg);
		}
		

		

		System.out.println(user.getPartyEntityList());

		return new ResponseEntity<UserEntity>(user, new HttpHeaders(), HttpStatus.OK);

	}
	
	
	
	@PostMapping(path = "uploadimg")

	public ResponseEntity<UserEntity> uploadUserProfile(@RequestParam("imageFile") MultipartFile file) throws Exception {
		byte[] image = compressBytes(file.getBytes());
		
		System.out.println(file.getOriginalFilename());
		UserEntity userEntity = userService.loadUserByUsernameUpload(file.getOriginalFilename(),image);
		
		//UserEntity user = userService.registerNewUserAccount(userDto);
//
		if (userEntity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", new Exception());
		}
		
		byte[] decompressImg = decompressBytes(userEntity.getUser_img());
		userEntity.setUser_img(decompressImg);
//
//		String token = authAndGenerateToken(user);
//		user.setFirstName(user.getFirstName() +"-"+ token);

		return new ResponseEntity<UserEntity>(userEntity, new HttpHeaders(), HttpStatus.OK);

	}
	
	
	@PostMapping(path = "createParty", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PartyEntity> createParty(@RequestBody CreatePartyDto userDto)
			throws Exception {
		UserEntity user = userService.loadUser(userDto.getUsername());
		
		PartyEntity partyEntity = userService.createParty(userDto,Long.valueOf(user.getUser_id()));

		System.out.println(userDto);
//		UserEntity userEntity = userService.forgotPasswordUser(userDto);
//		String token = jwtUtil.generateToken(userEntity.getEmail());
//		userEntity.setToken(token);
		return new ResponseEntity<PartyEntity>(partyEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(path = "searchParty", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<PartyEntityDto>> searchParty(@RequestBody SearchPartyDto searchDto)
			throws Exception {
		UserEntity user = userService.loadUser(searchDto.getUsername());
		List<PartyEntityDto> partyEntityDto= userService.searchParty(searchDto,user);
		
		
//		PartyEntity partyEntity = userService.createParty(userDto,Long.valueOf(user.getUser_id()));
//
//		System.out.println(userDto);
//		UserEntity userEntity = userService.forgotPasswordUser(userDto);
//		String token = jwtUtil.generateToken(userEntity.getEmail());
//		userEntity.setToken(token);
		return new ResponseEntity<List<PartyEntityDto>>(partyEntityDto, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	public  String authAndGenerateToken(UserEntity user) throws Exception {
		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return  jwtUtil.generateToken(user.getEmail());
	}
	
	
	// compress the image bytes before storing it in the database
	
	    public static byte[] compressBytes(byte[] data) {

	        Deflater deflater = new Deflater();
	
	        deflater.setInput(data);

	        deflater.finish();
	
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	
	        byte[] buffer = new byte[1024];
	
	        while (!deflater.finished()) {
	
	            int count = deflater.deflate(buffer);
	
	            outputStream.write(buffer, 0, count);
	
	        }
	
	        try {
	
	            outputStream.close();
	
	        } catch (IOException e) {

	        }

	        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
	
	        return outputStream.toByteArray();
	
	    }

	    public static byte[] decompressBytes(byte[] data) {
	
	        Inflater inflater = new Inflater();
	
	        inflater.setInput(data);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	
	        byte[] buffer = new byte[1024];

	        try {

	            while (!inflater.finished()) {
 
	                int count = inflater.inflate(buffer);

	                outputStream.write(buffer, 0, count);

	            }
	
	            outputStream.close();
	
	        } catch (IOException ioe) {
	
	        } catch (DataFormatException e) {

	        }

	        return outputStream.toByteArray();
	
	    }
	
	

}
