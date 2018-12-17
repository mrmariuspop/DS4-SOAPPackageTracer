package edu.assignment4.adminsws.webservice;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

	public WebServicePublisher() {
		
	}
	
	public void publish() {
		Endpoint.publish("http://localhost:8888/adminsws/tracepackage", new TracePackageWebServiceImpl());
	}
	
	public static void main(String[] args) {
		WebServicePublisher wspublisher = new WebServicePublisher();
		wspublisher.publish();
	}
}
