package edu.assignment4.adminsws.webservice.interfaces;

import java.util.ArrayList;

import edu.assignment4.adminsws.entity.TracePackage;

public class TracePackageArrayList {

	private ArrayList<TracePackage> packages;
	
	public TracePackageArrayList() {
		packages = new ArrayList<TracePackage>();
	}

	public ArrayList<TracePackage> getPackages() {
		return packages;
	}

	public void setPackages(ArrayList<TracePackage> packages) {
		this.packages = packages;
	}
}
