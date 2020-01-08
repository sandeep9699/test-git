package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.document.SigninDto;
import com.example.document.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public List<User> findAll(String user) {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public Optional<User> signin(String username) {
		return userRepository.findById(username);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	public User savePassword(User user2) {
		// TODO Auto-generated method stub
		return userRepository.save(user2);
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}
}
