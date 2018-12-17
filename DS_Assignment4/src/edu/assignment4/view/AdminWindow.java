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

import edu.assignment4.admisws.webservice.interfaces.TracePackage;
import edu.assignment4.services.AdminService;
import edu.assignment4.view.model.TracePackageTableModel;

public class AdminWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private AdminService as;

	private JPanel contentPane;
	private JTable table;

	public AdminWindow(AdminService as) {
		this.as = as;
		
		initialize();
	}
	
	public void initialize() {
		setTitle("Logged in as Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddPackage = new JButton("Add package");
		btnAddPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPackageDialog adp = new AddPackageDialog(as);
				adp.setVisible(true);
				
				setVisible(false);
				dispose();
			}
		});
		btnAddPackage.setBounds(10, 10, 160, 40);
		contentPane.add(btnAddPackage);
		
		JButton btnRemovePackage = new JButton("Remove package");
		btnRemovePackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row < 0) 
				{
					JOptionPane.showMessageDialog(null, "You must select a package!", "Error!", JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				TracePackage tp = (TracePackage)table.getValueAt(row, TracePackageTableModel.OBJECT_COL);
				
				as.deletePackage(tp.getId());
				refreshPackageList();
			}
		});
		btnRemovePackage.setBounds(176, 10, 160, 40);
		contentPane.add(btnRemovePackage);
		
		JButton btnTrackPackage = new JButton("Track package");
		btnTrackPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row < 0) 
				{
					JOptionPane.showMessageDialog(null, "You must select a package!", "Error!", JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				TracePackage tp = (TracePackage)table.getValueAt(row, TracePackageTableModel.OBJECT_COL);
				
				as.trackPackage(tp.getId());
				refreshPackageList();
			}
		});
		btnTrackPackage.setBounds(342, 10, 160, 40);
		contentPane.add(btnTrackPackage);
		
		JButton btnUpdateStatus = new JButton("Update status");
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row < 0) 
				{
					JOptionPane.showMessageDialog(null, "You must select a package!", "Error!", JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				TracePackage tp = (TracePackage)table.getValueAt(row, TracePackageTableModel.OBJECT_COL);
				String city = JOptionPane.showInputDialog("Input the current location of the package: ");
				
				as.updatePackageStatus(tp.getId(), city);
				refreshPackageList();
			}
		});
		btnUpdateStatus.setBounds(508, 10, 160, 40);
		contentPane.add(btnUpdateStatus);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow lw = new LoginWindow();
				lw.showLogin();
				
				setVisible(false);
				dispose();
			}
		});
		btnLogOut.setBounds(672, 10, 160, 40);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 822, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		refreshPackageList();
	}
	
	public void refreshPackageList() {
		ArrayList<TracePackage> packages = as.getAllPackages();
		table.setModel(new TracePackageTableModel(packages));
	}
}
