package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.document.SigninDto;
import com.example.document.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);

	}

	@GetMapping("/getall")
	public List<User> getAllUser(@PathVariable String user) {
		return userService.findAll(user);

	}

	@PostMapping("/signin")
	public String login(@RequestBody SigninDto dto) throws Exception {
		String username = dto.getUsername();
		String password = dto.getPassword();
		Optional<User> user = userService.signin(username);
		if (!user.isPresent()) {
			throw new Exception("Invalid Credentials");
		} else {

			if (!user.get().getPassword().equalsIgnoreCase(password)) {
				throw new Exception("Invalid PAssword");

			}
			return "Successfully Login";
		}
	}

	@PostMapping("/resetPassword/{userName}")
	public User resetPassword(@RequestBody User user, @PathVariable String userName) {
		User user2 = userService.findByUsername(userName);
		user2.setPassword(user.getPassword());
		user2.setPasswordConfirm(user.getPassword());
		return userService.savePassword(user2);

	}
	
	@PutMapping("/updateuser")
	public  User updateUser(@RequestBody User user) {
		return userService.save(user);
		
	}
	
	@GetMapping("/getUser/{userName}")
	public User getUser(@PathVariable String userName) {
		User user = userService.findByUsername(userName);
		if (user != null) {
			return user;
		}
		return null;
	}
	@DeleteMapping("/deleteUser/{userName}")
	public String deleteUser(@PathVariable String userName) {
		User user = userService.findByUsername(userName);
		userService.delete(user);
		return "User Deleted Successfully";
	}
}
