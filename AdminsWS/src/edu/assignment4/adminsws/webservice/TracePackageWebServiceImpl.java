package edu.assignment4.adminsws.webservice;

import java.util.ArrayList;

import javax.jws.WebService;

import edu.assignment4.adminsws.entity.TracePackage;
import edu.assignment4.adminsws.service.TracePackageService;
import edu.assignment4.adminsws.webservice.interfaces.TracePackageArrayList;
import edu.assignment4.adminsws.webservice.interfaces.TracePackageWebService;

@WebService(endpointInterface = "edu.assignment4.adminsws.webservice.interfaces.TracePackageWebService")
public class TracePackageWebServiceImpl implements TracePackageWebService {

	private TracePackageService service;
	
	public TracePackageWebServiceImpl() {
		service = new TracePackageService();
	}
	
	@Override
	public TracePackageArrayList getAllPackages() {
		ArrayList<TracePackage> packages = service.getAllPackages();;
		TracePackageArrayList tpal = new TracePackageArrayList();
		tpal.setPackages(packages);
		return tpal;
	}

	@Override
	public TracePackage getPackageById(int id) {
		return service.getPackageById(id);
	}

	@Override
	public void addPackage(String sender, String receiver, String name,
			String description, String sender_city, String destination_city) {
		service.addPackage(sender, receiver, name, description, sender_city, destination_city);
	}

	@Override
	public void deletePackage(int id) {
		service.deletePackage(id);
	}

	@Override
	public void trackPackage(int id) {
		service.trackPackage(id);
	}

	@Override
	public void updatePackageStatus(int id, String city) {
		service.updatePackageStatus(id, city);
	}
}
