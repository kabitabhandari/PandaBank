package com.panda.bank.cmr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.panda.bank.cmr.model.Appointment;



public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();


}
