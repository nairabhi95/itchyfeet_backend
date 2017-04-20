package com.itchyfeet.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itchyfeet.model.User;
import com.itchyfeet.repository.search.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchRepository searchRepository;
	
	public void register(User u){
		searchRepository.register(u);
	}

}
