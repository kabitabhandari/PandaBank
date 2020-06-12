package com.panda.bank.cmr.dao;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.security.Role;



public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
