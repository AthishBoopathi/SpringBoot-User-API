package com.example.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/hi")
	public String m1()
	{
		return"Hi Boss";
	}
	
	

}
