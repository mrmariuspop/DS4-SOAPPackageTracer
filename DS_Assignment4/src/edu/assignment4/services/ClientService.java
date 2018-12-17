package edu.assignment4.services;

import java.util.ArrayList;
import java.util.List;

import org.assignment4clientswebservice.ClientsWebService;
import org.assignment4clientswebservice.ClientsWebServiceSoap;
import org.assignment4clientswebservice.TracePackage;

public class ClientService {

	private ClientsWebServiceSoap service;
	
	public ClientService() {
		ClientsWebService cws = new ClientsWebService();
		service = cws.getClientsWebServiceSoap();
	}
	
	public String login(String username, String password) {
		return service.loginWS(username, password);
	}
	
	public void register(String username, String password) {
		service.registerWS(username, password);
	}
	
	public ArrayList<TracePackage> getAllPackages(String username) {
		ArrayList<TracePackage> packages = new ArrayList<TracePackage>();
		List<TracePackage> packages_list = service.getAllPackagesWS(username).getTracePackage();
		for (TracePackage tp : packages_list) {
			packages.add(tp);
		}
		return packages;
	}
	
	public ArrayList<TracePackage> searchPackages(String packagename) {
		ArrayList<TracePackage> packages = new ArrayList<TracePackage>();
		List<TracePackage> packages_list = service.searchPackagesWS(packagename).getTracePackage();
		for (TracePackage tp : packages_list) {
			packages.add(tp);
		}
		return packages;
	}
	
	public String checkPackageStatus(String packagename) {
		return service.checkPackageStatusWS(packagename);
	}
}
