package com.shortenerUrl.auction_shortened_url.controller;

import com.shortenerUrl.auction_shortened_url.model.dto.UrlRequestDto;
import com.shortenerUrl.auction_shortened_url.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UrlController {

	private final UrlService urlService;
	private final RestTemplate restTemplate;
	public UrlController(UrlService urlService, RestTemplate restTemplate) {
		this.urlService = urlService;
		this.restTemplate = restTemplate;
	}

	@GetMapping(value = "/url/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(urlService.getAll());
	}

	@GetMapping(value = "/url/get/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		return ResponseEntity.ok(urlService.getById(id));
	}


	@GetMapping("/{shortenedurl}")
	public ResponseEntity<?> redirect(@PathVariable String shortenedurl)  {
		return ResponseEntity.ok(urlService.redirectToLongUrl(shortenedurl));
	}

	@GetMapping(value = "/url/getbyuserid/{id}")
	public ResponseEntity<?> getUrlsByUserId(@PathVariable int id) {
		return ResponseEntity.ok(urlService.getUrlsByUserId(id));
	}

	@PostMapping(value = "/user/{id}/url/create")
	public ResponseEntity<?> create(@Valid @PathVariable("id") int id, @RequestParam String longUrl) {
		return ResponseEntity.ok(urlService.create(id, longUrl));
	}

	@PutMapping(value = "/url/update")
	public ResponseEntity<?> update(@RequestBody UrlRequestDto requestDto) {
		return ResponseEntity.ok(urlService.update(requestDto));
	}

	@DeleteMapping(value = "/url/delete")
	public ResponseEntity<?> delete(int urlId) {
		return ResponseEntity.ok(urlService.delete(urlId));
	}
	

}
