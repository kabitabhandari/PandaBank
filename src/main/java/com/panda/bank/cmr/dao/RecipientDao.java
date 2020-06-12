package com.panda.bank.cmr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.Recipient;



public interface RecipientDao extends CrudRepository<Recipient, Long> {
    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}
