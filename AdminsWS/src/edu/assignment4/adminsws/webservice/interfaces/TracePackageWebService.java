package edu.assignment4.adminsws.webservice.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.assignment4.adminsws.entity.TracePackage;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TracePackageWebService {

	@WebMethod
	public TracePackageArrayList getAllPackages();
	
	@WebMethod
	public TracePackage getPackageById(int id);
	
	@WebMethod
	public void addPackage(String sender, String receiver, String name, String description, String sender_city, String destination_city);
	
	@WebMethod
	public void deletePackage(int id);
	
	@WebMethod
	public void trackPackage(int id);
	
	@WebMethod
	public void updatePackageStatus(int id, String city);
}
