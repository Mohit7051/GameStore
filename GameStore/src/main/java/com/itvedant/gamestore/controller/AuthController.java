package com.itvedant.gamestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itvedant.gamestore.dao.LoginDao;
import com.itvedant.gamestore.dao.RegisterDao;
import com.itvedant.gamestore.entity.User;
import com.itvedant.gamestore.service.UserService;

@Controller
@RequestMapping("/users")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody RegisterDao resiRegisterDao){
		return ResponseEntity.ok(this.userService.createUser(resiRegisterDao));
	}
	
	@GetMapping("/login")
	public String log(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") LoginDao loginDao, Model model){   // requestBody convert code json to java
		model.addAttribute("user", loginDao);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDao.getEmail(),
						                                loginDao.getPassword()));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				return "home";
		
	}
	
	@GetMapping("/register")
	public String registerGet(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") RegisterDao registerDao, Model model) {
		model.addAttribute("user", registerDao);
		this.userService.createUser(registerDao);
		return "index";
		
	}

}
