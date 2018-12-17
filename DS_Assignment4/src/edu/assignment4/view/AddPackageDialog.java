package edu.assignment4.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.assignment4.services.AdminService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPackageDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private AdminService as;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField senderTextField;
	private JTextField receiverTextField;
	private JTextField packagenameTextField;
	private JTextField packagedescrTextField;
	private JTextField sendercityTextField;
	private JTextField destcityTextField;

	public AddPackageDialog(AdminService as) {
		
		this.as = as;
		
		initialize();
	}
	
	public void initialize() {
		setTitle("Add package");
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSender = new JLabel("Sender");
			lblSender.setBounds(10, 11, 100, 30);
			contentPanel.add(lblSender);
		}
		{
			JLabel lblReceiver = new JLabel("Receiver");
			lblReceiver.setBounds(10, 52, 100, 30);
			contentPanel.add(lblReceiver);
		}
		{
			JLabel lblPackageName = new JLabel("Package name");
			lblPackageName.setBounds(10, 93, 100, 30);
			contentPanel.add(lblPackageName);
		}
		{
			JLabel lblPackageDescription = new JLabel("Package description");
			lblPackageDescription.setBounds(10, 134, 100, 30);
			contentPanel.add(lblPackageDescription);
		}
		{
			JLabel lblSenderCity = new JLabel("Sender city");
			lblSenderCity.setBounds(10, 175, 100, 30);
			contentPanel.add(lblSenderCity);
		}
		{
			JLabel lblDestinationCity = new JLabel("Destination city");
			lblDestinationCity.setBounds(10, 216, 100, 30);
			contentPanel.add(lblDestinationCity);
		}
		{
			senderTextField = new JTextField();
			senderTextField.setBounds(120, 11, 304, 30);
			contentPanel.add(senderTextField);
			senderTextField.setColumns(10);
		}
		{
			receiverTextField = new JTextField();
			receiverTextField.setColumns(10);
			receiverTextField.setBounds(120, 52, 304, 30);
			contentPanel.add(receiverTextField);
		}
		{
			packagenameTextField = new JTextField();
			packagenameTextField.setColumns(10);
			packagenameTextField.setBounds(120, 93, 304, 30);
			contentPanel.add(packagenameTextField);
		}
		{
			packagedescrTextField = new JTextField();
			packagedescrTextField.setColumns(10);
			packagedescrTextField.setBounds(120, 134, 304, 30);
			contentPanel.add(packagedescrTextField);
		}
		{
			sendercityTextField = new JTextField();
			sendercityTextField.setColumns(10);
			sendercityTextField.setBounds(120, 175, 304, 30);
			contentPanel.add(sendercityTextField);
		}
		{
			destcityTextField = new JTextField();
			destcityTextField.setColumns(10);
			destcityTextField.setBounds(120, 216, 304, 30);
			contentPanel.add(destcityTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sender = senderTextField.getText();
						String receiver = receiverTextField.getText();
						String name = packagenameTextField.getText();
						String description = packagedescrTextField.getText();
						String sender_city = sendercityTextField.getText();
						String destination_city = destcityTextField.getText();
						
						as.addPackage(sender, receiver, name, description, sender_city, destination_city);
						
						setVisible(false);
						dispose();
						
						AdminWindow aw = new AdminWindow(as);
						aw.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
						AdminWindow aw = new AdminWindow(as);
						aw.setVisible(true);
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
