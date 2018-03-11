package com.stockmanager.userstockservice.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockmanager.userstockservice.exception.CustomException;
import com.stockmanager.userstockservice.model.User;
import com.stockmanager.userstockservice.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<List<User>>> getAll() {

		DeferredResult<ResponseEntity<List<User>>> result = new DeferredResult<>(); ;
		userService.getAll().
		subscribe(list -> {
			result.setResult(new ResponseEntity<>(list,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}

	@RequestMapping(value = "/{name}" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<User>> getByName(@PathVariable("name")String name) {

		DeferredResult<ResponseEntity<User>> result = new DeferredResult<>(); ;
		userService.getByName(name).
		subscribe(user -> {
			result.setResult(new ResponseEntity<>(user,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}

	@RequestMapping(value = "/" , method=RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody User user,Errors errors,UriComponentsBuilder uc) {


		if(errors.hasErrors()) {
			String er = errors.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
			throw new CustomException(er,HttpStatus.BAD_REQUEST);
		}

		User tempUser = null;
		try {
			tempUser = userService.getByName(user.getName()).toBlocking().first();

		}catch(CustomException ex){

		}
		if(tempUser!=null)
			throw new CustomException("User already exist",HttpStatus.CONFLICT);


		user = userService.save(user);
		HttpHeaders header = new HttpHeaders();
		URI uri = uc.path("/user/{name}").buildAndExpand(user.getName()).toUri();
		header.setLocation(uri);
		return new ResponseEntity<Void>(header,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{name}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String name) {
		User user = userService.getByName(name).toBlocking().first();
		userService.delete(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
