package com.shortenerUrl.auction_shortened_url.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="url")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","user"})
public class Url {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="url can not be empty")
	@Column(name="long_url")
	private String longUrl;
	
	@Column(name="shortened_url")
	private String shortenedUrl;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	User user;
	
	
}
