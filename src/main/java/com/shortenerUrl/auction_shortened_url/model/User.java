package com.shortenerUrl.auction_shortened_url.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "url"})
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "username can not be empty")
    @NotBlank
    @Size(min=5, max=15,message = "username must be between 5-15 character")
	@Column(name="username")
	private String username;
	
	@NotNull(message = "Password can not be empty")
    @NotBlank
    @Size(min=5, max=10,message = "password must be between 5-15 character")
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Url> url;

	

	
}
