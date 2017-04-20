package com.itchyfeet.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.itchyfeet.model.User;
import com.itchyfeet.service.search.SearchService;

@Controller
@EnableWebMvc
@RequestMapping("/user")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	Logger log =  Logger.getLogger(SearchController.class.getName());
	

	/*@RequestMapping("/search")
	public ModelAndView search() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>**********Search page for our application(Redirect to respective location page)**********</h3></div><br><br>";
		return new ModelAndView("search", "message", message);
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>**********Search page for our application(Redirect to respective location page)**********</h3></div><br><br>";
		return new ModelAndView("login", "message", message);
	}*/
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> register() {
		//log.getGlobal();
		User user = new User();
		user.setContactNo(324);
		user.setEmailId("test");
		user.setFirstName("Test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public ResponseEntity<User> registerUser() {
		//log.getGlobal();
		User user = new User();
		User user1 = new User();
		
		user.setContactNo(123);
		user.setEmailId("test");
		user.setFirstName("Test");
		user.setId(1);
		user.setLastName("test");
		user.setPassword("test");
		searchService.register(user);
		user1.setContactNo(123);
		user1.setEmailId("test");
		user1.setFirstName("Test");
		user1.setId(1);
		user1.setLastName("test");
		user1.setPassword("test");
		return new ResponseEntity<User>(user1, HttpStatus.OK);
		
	}
	
}
