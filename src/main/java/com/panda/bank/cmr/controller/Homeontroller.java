package com.panda.bank.cmr.controller;

import java.security.Principal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.bank.cmr.dao.RoleDao;
import com.panda.bank.cmr.model.PrimaryAccount;
import com.panda.bank.cmr.model.SavingsAccount;
import com.panda.bank.cmr.model.User;
import com.panda.bank.cmr.security.UserRole;
import com.panda.bank.cmr.service.UserService;


@Controller // to register the kind of class as a controller
//with this annotation this class will be registered as a bean in the spring container automatically(specialization
//of @component class and allows implementation classes to be auto detected through the classpath scanning.
public class Homeontroller {

@Autowired
private UserService userService;
@Autowired
private RoleDao roleDao;


	@RequestMapping("/")
	// @RequestMapping(value="/", method =RequestMethod.GET)
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	// @RequestMapping(value="/index", method =RequestMethod.GET)
	public String index() {
		return "index"; // will return index.html
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user,  Model model) {

        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
        	 Set<UserRole> userRoles = new HashSet<>();
             userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
//            else {
//            	userService.save(user);
//            	return "redirect:/";
//            }
            
            
    }


	
	  @RequestMapping("/userFront") public String userFront(Principal principal,
	  Model model) { User user = userService.findByUsername(principal.getName());
	  PrimaryAccount primaryAccount = user.getPrimaryAccount(); SavingsAccount
	  savingsAccount = user.getSavingsAccount();
	  
	  model.addAttribute("primaryAccount", primaryAccount);
	  model.addAttribute("savingsAccount", savingsAccount);
	  
	  return "userFront"; }
	 
}
