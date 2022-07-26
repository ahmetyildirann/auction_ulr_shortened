package com.shortenerUrl.auction_shortened_url.service;

import com.github.dozermapper.core.Mapper;
import com.shortenerUrl.auction_shortened_url.model.User;
import com.shortenerUrl.auction_shortened_url.model.dto.UserRequestDto;
import com.shortenerUrl.auction_shortened_url.model.dto.UserResponseDto;
import com.shortenerUrl.auction_shortened_url.exception.NotFoundException;
import com.shortenerUrl.auction_shortened_url.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class  UserService {

	private final UserRepository userRepository;
	private final Mapper dozerMapper;

	public UserService(UserRepository userRepository, Mapper dozerMapper) {
		this.userRepository = userRepository;
		this.dozerMapper = dozerMapper;

	}

	public UserResponseDto add(UserRequestDto userReqDto) {
		User user = dozerMapper.map(userReqDto, User.class);
		userRepository.save(user);
		return dozerMapper.map(user, UserResponseDto.class);

	}

	public List<UserResponseDto> getAll(){
		List<UserResponseDto> response=new ArrayList<UserResponseDto>();
		userRepository.findAll().forEach(user->{
			response.add(dozerMapper.map(user, UserResponseDto.class));
		});
		return response;
	}

	public User getById(int id) {
		Optional<User> user =userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
			
		
		throw new NotFoundException("There is no such id in our system!!");
	}

}