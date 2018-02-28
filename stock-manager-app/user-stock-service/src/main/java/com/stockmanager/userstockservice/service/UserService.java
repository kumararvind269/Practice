package com.stockmanager.userstockservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stockmanager.userstockservice.exception.CustomException;
import com.stockmanager.userstockservice.model.User;
import com.stockmanager.userstockservice.repo.UserRepository;
import rx.Observable;
import rx.schedulers.Schedulers;

@Service
@SuppressWarnings("deprecation")
public class UserService {

	@Autowired
	UserRepository UserRepo;

	public Observable<List<User>> getAll(){
		return Observable.<List<User>>create(s->{
			List<User> list = UserRepo.findAll();
			if(!list.isEmpty())
				s.onNext(list);
			else
				s.onError(new CustomException("No user Found",HttpStatus.NOT_FOUND));
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}

	public Observable<User> getByName(String name) {
		return Observable.<User>create(s->{
			User user = UserRepo.findByName(name);
			if(user!=null)
				s.onNext(user);
			else
				s.onError(new CustomException("User doesn't exist",HttpStatus.NOT_FOUND));
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}

	public User save(User user) {
		return UserRepo.save(user);		
	}


	public void delete(User user) {
		UserRepo.delete(user);
	}
	
}
