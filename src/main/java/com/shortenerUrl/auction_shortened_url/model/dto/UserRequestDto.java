package com.shortenerUrl.auction_shortened_url.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
	@NotNull(message = "username can not be empty")
    @NotBlank
    @Size(min=5, max=15,message = "username must be between 5-15 character")
	 String username;
	

	@NotNull(message = "Password can not be empty")
    @NotBlank
    @Size(min=5, max=10,message = "password must be between 5-15 character")
	 String password;
}
