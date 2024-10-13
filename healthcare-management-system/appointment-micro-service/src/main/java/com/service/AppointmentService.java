package com.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Doctor;
import com.bean.Patient;
import com.entity.Appointment;
import com.entity.Slot;
import com.repository.AppointmentRepository;
import com.repository.SlotRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	SlotRepository slotRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String createAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		Patient patient = restTemplate.getForObject("http://PATIENT-MICRO-SERVICE/patient/findbyid/"+appointment.getPid(), Patient.class);
		if(patient != null)
		{
			Doctor doctor = restTemplate.getForObject("http://DOCTOR-MICRO-SERVICE/doctor/findbyid/"+appointment.getDid(), Doctor.class);
            if(doctor != null)
            {
            	LocalTime timeslot = appointment.getTimeslot();
            	Slot slot = slotRepository.getSlotByTime(timeslot);
            	if(!slot.isBookFlag())
            	{
            		appointment.setPatientName(patient.getPname());
            		appointment.setDoctorName(doctor.getDname());
            		appointmentRepository.save(appointment);
            		slotRepository.updateSlotDetails(true, slot.getSid(),doctor.getDid());
            		return "Slot Booked Successfully";
            	}
            	else
            	{
            		return "This time slot is already booked, try booking another slot!";
            	}
            	
            }
            else
            {
            	return "Doctor Record Doesnot exists";
            }
		}
		else
		{
			return "Patient Record Doesnot exists";
		}
	}

	public Optional<Appointment> findAppointmentById(Integer id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id);
	}

	public String updateAppointmentDetails(Appointment appointment) {
		Optional<Appointment> result = appointmentRepository.findById(appointment.getAid());
		if(result.isEmpty())
		{
			return "Appointment with given id doesn't exists!";
		}
		else
		{
			LocalTime newtimeslot = appointment.getTimeslot();
			LocalTime oldtimeslot = appointmentRepository.getSlotIdById(appointment.getAid());
        	Slot newslot = slotRepository.getSlotByTime(newtimeslot);
        	Slot oldslot = slotRepository.getSlotByTime(oldtimeslot);
        	if(!newslot.isBookFlag())
        	{
        		appointmentRepository.updateAppointmentTime(newtimeslot, appointment.getAid());
        		slotRepository.updateSlotDetails(true, newslot.getSid(),Integer.parseInt(appointment.getDid()));
        		slotRepository.updateSlotDetails(false, oldslot.getSid(),Integer.parseInt(appointment.getDid()));
        		return "Slot Timings Updated Successfully";
        	}
        	else
        	{
        		return "This slot is already occupied, Try booking for some other slot";
        	}
			
		}
	}

	public String deleteAppointmentById(int aid) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointment = appointmentRepository.findById(aid);
		if(appointment.isEmpty())
		{
			return "Appointment with given id doesn't exists!";
		}
		else
		{
			LocalTime oldtimeslot = appointmentRepository.getSlotIdById(aid);
        	Slot oldslot = slotRepository.getSlotByTime(oldtimeslot);
        	slotRepository.updateSlotDetails(false, oldslot.getSid(),Integer.parseInt(appointment.get().getDid()));
			appointmentRepository.deleteById(aid);
	        return "Appointment has been cancelled Successfully!";
		}
	}

}
