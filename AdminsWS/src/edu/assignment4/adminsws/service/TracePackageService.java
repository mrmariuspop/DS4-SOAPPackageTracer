package edu.assignment4.adminsws.service;

import java.util.ArrayList;

import edu.assignment4.adminsws.dao.TracePackageDAO;
import edu.assignment4.adminsws.entity.TracePackage;

public class TracePackageService {

	private TracePackageDAO dao;
	
	public TracePackageService() {
		dao = new TracePackageDAO();
	}
	
	public ArrayList<TracePackage> getAllPackages() {
		return dao.getAllPackages();
	}
	
	public TracePackage getPackageById(int id) {
		return dao.getPackageById(id);
	}
	
	public void addPackage(String sender, String receiver, String name, String description, String sender_city, String destination_city) {
		TracePackage tpackage = new TracePackage();
		tpackage.setSender(sender);
		tpackage.setReceiver(receiver);
		tpackage.setName(name);
		tpackage.setDescription(description);
		tpackage.setSender_city(sender_city);
		tpackage.setDestination_city(destination_city);
		tpackage.setTracking("false");
		tpackage.setCurrent_city(sender_city);
		
		dao.addPackage(tpackage);
	}
	
	public void deletePackage(int id) {
		TracePackage tpackage = dao.getPackageById(id);
		dao.deletePackage(tpackage);
	}
	
	public void trackPackage(int id) {
		TracePackage tpackage = dao.getPackageById(id);
		tpackage.setTracking("true");
		dao.updatePackage(tpackage);
	}
	
	public void updatePackageStatus(int id, String city) {
		TracePackage tpackage = dao.getPackageById(id);
		tpackage.setCurrent_city(city);
		dao.updatePackage(tpackage);
	}
}
