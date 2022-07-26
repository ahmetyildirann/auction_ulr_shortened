package com.shortenerUrl.auction_shortened_url.repository;

import com.shortenerUrl.auction_shortened_url.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	
}
