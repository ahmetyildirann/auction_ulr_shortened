package com.shortenerUrl.auction_shortened_url.controller;

import com.shortenerUrl.auction_shortened_url.model.dto.UserRequestDto;
import com.shortenerUrl.auction_shortened_url.service.UrlService;
import com.shortenerUrl.auction_shortened_url.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private final UserService userService;
	private final UrlService urlService;
	
	public UserController(UserService userService, UrlService urlService) {
		this.userService = userService;
		this.urlService = urlService;
		
	}

	@PostMapping(value="/signup")
	public ResponseEntity<?> add(@Valid UserRequestDto user) {
		return ResponseEntity.ok(userService.add(user));
	}
	@GetMapping(value="/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userService.getAll());
	}
	@GetMapping(value="/getbyid/{id}")
	public ResponseEntity<?> getAll(@PathVariable int id){
		return ResponseEntity.ok(userService.getById(id));
	}


	
}
