
 package com.panda.bank.cmr.dao;
 
 import java.util.List;
 
 import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.User;
 

 public interface UserDao extends CrudRepository<User, Long> {  // model name. PKey
	 User findByUsername(String username); // empty methods declaration only
	 User findByEmail(String email); 
	 List<User> findAll();
	 }
 