package com.example.Project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.User;
import com.example.Project.Repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository ur;

//	
//	@PostMapping("/saveuser")
//	public String saveuser(@RequestBody User u)
//	{
//	   ur.save(u);
//	return "Boss User Saved Successfully..!";
//	}
//	
//	@PostMapping("/saveuserinfo")
//	public ResponceStructure<User> saveuserinfo(@RequestBody User u)
//	{
//		ur.save(u);
//		ResponceStructure<User> rs= new ResponceStructure<User>();
//		rs.setStatuscode(HttpStatus.CREATED.value());
//		rs.setData(u);
//		rs.setMessage("Data saved Successfully Boss..!");
//		return rs;
//	}
	@GetMapping("/fetchuserById")
	public ResponceStructure<User> fetchuserById(@RequestParam("id") int id) {
		Optional<User> o = ur.findById(id);
		if (o.isPresent()) {
			User u = o.get();
			ResponceStructure<User> rs = new ResponceStructure<User>();
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setData(u);
			rs.setMessage("FetchUser ById Successfully Done...!");
			return rs;
		} else {
			ResponceStructure<User> rs = new ResponceStructure<User>();
			rs.setMessage("NOT FOund");

			return rs;
		}

	}

	@PutMapping("/updatesalaryById/{id}")
	public ResponceStructure<User> updatesalaryById(@PathVariable("id") int id, @RequestBody User us) {

		User user = ur.findById(id).get();
		user.setSalary(us.getSalary());

		
		ur.save(user);
		
		ResponceStructure<User> rs = new ResponceStructure<User>();
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Salary Update Successfully Done..!");
		rs.setData(user);
		return rs;
	}

	@DeleteMapping("/deleteuserById/{id}")
	public ResponceStructure<User> deleteuserById(@PathVariable("id") int id) {
		
		ur.deleteById(id);
		
		ResponceStructure<User> rs = new ResponceStructure<User>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Deleted User ById is Successfully Done...!");
		return rs;
	}

}
