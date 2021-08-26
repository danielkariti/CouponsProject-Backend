package com.daniel.coupons.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.coupons.beans.ChangePasswordDetails;
import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.beans.SuccessfulLoginData;
import com.daniel.coupons.beans.User;
import com.daniel.coupons.beans.UserLoginDetails;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.UsersController;


@RestController
@RequestMapping("/user")
public class UsersApi {

	
	@Autowired
	private UsersController usersController;

	@PostMapping("/register")
	public void createUser(@RequestBody User user) throws ApplicationException {
		this.usersController.createUser(user);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) throws ApplicationException {
		this.usersController.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") long id) throws ApplicationException {
		this.usersController.removeUser(id);

	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long id) throws ApplicationException {
		return this.usersController.getUser(id);

	}
	@PostMapping("/login")
	public SuccessfulLoginData login(@RequestBody UserLoginDetails userLoginDetails) throws ApplicationException {
		return this.usersController.login(userLoginDetails);
	}
	@GetMapping
	public List<User> getAllUsers() throws ApplicationException {
		return this.usersController.getAllUsers();
	}
	@GetMapping("/byCompany")
	public List<User> getAllUsersByCompanyID(@RequestParam("id")long companyId) throws ApplicationException {
		return this.usersController.getAllUsersByCompanyID(companyId);
	}

	@PutMapping("/changePassword")
	public void changePassword(@RequestBody ChangePasswordDetails changePasswordDetails, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		User user = this.usersController.getUser(postLoginData.getId());
		this.usersController.changePassword(user.getUsername(), changePasswordDetails.getOldPassword(), changePasswordDetails.getNewPassword());
	}

}

