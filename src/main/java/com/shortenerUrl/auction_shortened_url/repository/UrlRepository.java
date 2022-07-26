package com.shortenerUrl.auction_shortened_url.repository;

import com.shortenerUrl.auction_shortened_url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url,Integer> {

	Optional<Url> getByShortenedUrl(String shortenedUrl);
	//Url getByLongUrl(String longUrl);
	List<Url> getByUser_Id(int id);
}
