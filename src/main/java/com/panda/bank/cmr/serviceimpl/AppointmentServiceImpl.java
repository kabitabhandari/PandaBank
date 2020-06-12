package com.panda.bank.cmr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.bank.cmr.dao.AppointmentDao;
import com.panda.bank.cmr.model.Appointment;
import com.panda.bank.cmr.service.AppointmentService;



@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    public Appointment createAppointment(Appointment appointment) {
       return appointmentDao.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

//    public Appointment findAppointment(Long id) {
//        return appointmentDao.findOne(id);
//    }

//    public void confirmAppointment(Long id) {
//        Appointment appointment = findAppointment(id);
//        appointment.setConfirmed(true);
//        appointmentDao.save(appointment);
//    }
}
