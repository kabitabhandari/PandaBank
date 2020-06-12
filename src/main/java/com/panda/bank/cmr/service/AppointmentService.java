package com.panda.bank.cmr.service;

import java.util.List;

import com.panda.bank.cmr.model.Appointment;



public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

  }
