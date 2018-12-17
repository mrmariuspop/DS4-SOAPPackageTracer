package edu.assignment4.view.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.assignment4.admisws.webservice.interfaces.TracePackage;

public class TracePackageTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private static final int ID_COL = 0;
	private static final int SENDER_COL = 1;
	private static final int RECEIVER_COL = 2;
	private static final int NAME_COL = 3;
	private static final int DESCRIPTION_COL = 4;
	private static final int SENDERCITY_COL = 5;
	private static final int DESTINATIONCITY_COL = 6;
	private static final int TRACKING_COL = 7;
	private static final int CURRENTCITY_COL = 8;
	public static final int OBJECT_COL = -1;

	private String[] columnNames = {"ID", "Sender", "Receiver", "Name", "Description", "Sender City", "Destination City", "Tracking", "Current City"};
	private ArrayList<TracePackage> packages;

	public TracePackageTableModel(ArrayList<TracePackage> packages) {
		this.packages = packages;
	}
	
	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount() 
	{
		return packages.size();
	}

	@Override
	public String getColumnName(int col) 
	{
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) 
	{

		TracePackage tp = packages.get(row);

		switch (col) {
		case ID_COL:
			return tp.getId();
		case SENDER_COL:
			return tp.getSender();
		case RECEIVER_COL:
			return tp.getReceiver();
		case NAME_COL:
			return tp.getName();
		case DESCRIPTION_COL:
			return tp.getDescription();
		case SENDERCITY_COL:
			return tp.getSenderCity();
		case DESTINATIONCITY_COL:
			return tp.getDestinationCity();
		case TRACKING_COL:
			return tp.getTracking();
		case CURRENTCITY_COL:
			return tp.getCurrentCity();
		case OBJECT_COL:
			return tp;
		default:
			return tp.getId();
		}
	}

}
