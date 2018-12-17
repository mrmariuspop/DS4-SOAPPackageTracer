package edu.assignment4.adminsws.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.assignment4.adminsws.entity.TracePackage;
import edu.assignment4.adminsws.util.HibernateConfig;

public class TracePackageDAO {

	private Session session;
	
	public TracePackageDAO() {
		session = HibernateConfig.getSessionFactory().openSession();
	}
	
	public ArrayList<TracePackage> getAllPackages() {
		Query query = session.createQuery("From TracePackage");
		session.beginTransaction();
		ArrayList<TracePackage> packages = (ArrayList<TracePackage>)query.list();
		session.getTransaction().commit();
		return packages;
	}
	
	public TracePackage getPackageById(int id) {
		session.beginTransaction();
		TracePackage tpackage = (TracePackage)session.get(TracePackage.class, id);	
		session.getTransaction().commit();
		return tpackage;
	}
	
	public void addPackage(TracePackage tpackage) {
		session.beginTransaction();
		session.save(tpackage);
		session.getTransaction().commit();
	}
	
	public void updatePackage(TracePackage tpackage) {
		session.beginTransaction();
		session.update(tpackage);
		session.getTransaction().commit();
	}
	
	public void deletePackage(TracePackage tpackage) {
		session.beginTransaction();
		session.delete(tpackage);
		session.getTransaction().commit();
	}
	
	public void close() {
		session.close();
		HibernateConfig.shutdown();
	}
}
