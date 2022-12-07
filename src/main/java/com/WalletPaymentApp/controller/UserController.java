package com.WalletPaymentApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.WalletPaymentApp.model.Users;
import com.WalletPaymentApp.repository.UserRepo;

//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.WalletPaymentApp.model.User00;
//import com.WalletPaymentApp.repository.UserRepository;
//
//@RestController
//public class UserController {
//	
//	//private final static Logger LOGGER = Logger.getLogger(Logger.ROOT_LOGGER_NAME);
//    @Autowired
//    private UserRepository repository;
//    
//    
//    
//    //Regiestering all user
//    
//    
//    @PostMapping("/users")
//    //return 201 instead of 200
//    @ResponseBody
//    User00 newUser(@RequestBody User00 newUser) {
//        return repository.save(newUser);
//    }
//    
//    //Finding a user
//    
//    @GetMapping("/users")
//    List<User00> findAll() {
//        return repository.findAll();
//    }
//	
//	//finding a user
//    
//    @GetMapping("/users/{id}")
//    User00 findOne(@PathVariable int id) {
//        LOGGER.info("/users/{id} called with id " + id);
//        // Optional<User> user = repository.findById(id);
//        return repository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//}

@Controller
public class UserController {
	@Autowired(required = true)
	private UserRepo repo;
	
	@GetMapping("/")
	public String login(Model model) {
		Users users = new Users();
		model.addAttribute("user", users);
		return "login";
	}
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("user") Users users) {
		System.out.println(users.getUserId());
     	System.out.println(users.getPassword());
     	String userId=users.getUserId();
     	Users userdata=this.repo.findByUserId(userId);
     	if(users.getPassword().equals(userdata.getPassword())) {
     		return "home";
     	}
     	else {
     		return "error";
     	}
		
	}
}
