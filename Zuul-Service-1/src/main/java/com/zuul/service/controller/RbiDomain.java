package com.zuul.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuul.service.domain.RBIDomain;
import com.zuul.service.security.MyUserDetailsService;
import com.zuul.service.service.RBIBankService;
import com.zuul.service.util.ApiRequest;
import com.zuul.service.util.ApiResponse;
import com.zuul.service.util.JwtUtil;



@RestController
public class RbiDomain {
	
	@Autowired
	public RBIBankService service;
	
	@Autowired
	public ObjectMapper mapper;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager auth;
	
	@PostMapping("/bank")
	public ResponseEntity<String> saveRbiBankData(@RequestBody RBIDomain rbiDomain) throws JsonProcessingException{
		System.out.println(rbiDomain.toString());
		
		return new ResponseEntity<String>(mapper.writeValueAsString(service.saveRbiData(rbiDomain)),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getBank")
	public ResponseEntity<String> getDataById(@RequestParam long bid) throws JsonProcessingException{
		
		return new ResponseEntity<String>(mapper.writeValueAsString(service.getDataById(bid)),HttpStatus.OK);
		
	}	
	
	@PostMapping("/token")
	public ResponseEntity<ApiResponse> getTokenId(@RequestBody ApiRequest user) throws JsonProcessingException{
		//System.out.println(rbiDomain.toString());
		
		auth.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		final UserDetails userDetails=userDetailsService.loadUserByUsername(user.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		System.out.println(jwt);
		
		return ResponseEntity.ok(new ApiResponse(jwt));
		
	}
	

}
