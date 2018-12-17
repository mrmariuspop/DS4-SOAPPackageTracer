package edu.assignment4.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.assignment4clientswebservice.TracePackage;

import edu.assignment4.services.ClientService;
import edu.assignment4.view.model.ClientTracePackageTableModel;
import edu.assignment4.view.model.TracePackageTableModel;

public class ClientWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ClientService cs;
	private String username;
	
	private JPanel contentPane;
	private JTable table;

	public ClientWindow(ClientService cs, String username) {
		this.cs = cs;
		this.username = username;
		
		initialize();
	}
	
	public void initialize() {
		setTitle("Logged in as Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplayPackages = new JButton("Display packages");
		btnDisplayPackages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TracePackage> packages = cs.getAllPackages(username);
				table.setModel(new ClientTracePackageTableModel(packages));
			}
		});
		btnDisplayPackages.setBounds(10, 10, 160, 40);
		contentPane.add(btnDisplayPackages);
		
		JButton btnSearchPackages = new JButton("Search packages");
		btnSearchPackages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String packagename = JOptionPane.showInputDialog("Input the name of the package: ");
				ArrayList<TracePackage> packages = cs.searchPackages(packagename);
				table.setModel(new ClientTracePackageTableModel(packages));
			}
		});
		btnSearchPackages.setBounds(176, 10, 160, 40);
		contentPane.add(btnSearchPackages);
		
		JButton btnCheckPackageStatus = new JButton("Check package status");
		btnCheckPackageStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row < 0) 
				{
					JOptionPane.showMessageDialog(null, "You must select a package!", "Error!", JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				TracePackage tp = (TracePackage)table.getValueAt(row, TracePackageTableModel.OBJECT_COL);
				
				if (tp.getTracking().equals("false")) {
					JOptionPane.showMessageDialog(null, "Package is not registered for tracking!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String status = cs.checkPackageStatus(tp.getName());
					
					JOptionPane.showMessageDialog(null, "The package is currently in " + status + ".", "Package current location", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCheckPackageStatus.setBounds(342, 10, 160, 40);
		contentPane.add(btnCheckPackageStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 658, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow lw = new LoginWindow();
				lw.showLogin();
				
				setVisible(false);
				dispose();
			}
		});
		btnLogOut.setBounds(508, 10, 160, 40);
		contentPane.add(btnLogOut);
	}
}
