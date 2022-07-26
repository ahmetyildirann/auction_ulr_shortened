package com.shortenerUrl.auction_shortened_url.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private int id;

	private String username;

	private String password;
}
