package edu.assignment4.services;

import java.util.ArrayList;
import java.util.List;

import edu.assignment4.adminsws.webservice.TracePackageWebService;
import edu.assignment4.adminsws.webservice.TracePackageWebServiceImplService;
import edu.assignment4.admisws.webservice.interfaces.TracePackage;

public class AdminService {

	private TracePackageWebService service;
	
	public AdminService() {
		TracePackageWebServiceImplService tpws = new TracePackageWebServiceImplService();
		service = tpws.getTracePackageWebServiceImplPort();
	}
	
	public ArrayList<TracePackage> getAllPackages() {
		ArrayList<TracePackage> packages = new ArrayList<TracePackage>();
		List<TracePackage> packages_list = service.getAllPackages().getPackages();
		for (TracePackage tp : packages_list) {
			packages.add(tp);
		}
		return packages;
	}
	
	public TracePackage getPackageById(int id) {
		return service.getPackageById(id);
	}
	
	public void addPackage(String sender, String receiver, String name, String description, String sender_city, String destination_city) {
		service.addPackage(sender, receiver, name, description, sender_city, destination_city);
	}
	
	public void deletePackage(int id) {
		service.deletePackage(id);
	}
	
	public void trackPackage(int id) {
		service.trackPackage(id);
	}
	
	public void updatePackageStatus(int id, String city) {
		service.updatePackageStatus(id, city);
	}
}
