package com.itchyfeet.repository.search;

import org.springframework.stereotype.Repository;

import com.itchyfeet.model.User;

@Repository
public interface SearchRepository {
	
	public void register(User u);

}
