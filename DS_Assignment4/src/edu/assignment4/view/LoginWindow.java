package edu.assignment4.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.assignment4.services.AdminService;
import edu.assignment4.services.ClientService;

public class LoginWindow {

	private AdminService as;
	private ClientService cs;
	
	private JFrame frmPackageTracer;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	public LoginWindow() {
		as = new AdminService();
		cs = new ClientService();
		
		initialize();
	}

	private void initialize() {
		frmPackageTracer = new JFrame();
		frmPackageTracer.setTitle("Online Tracking System");
		frmPackageTracer.setBounds(100, 100, 260, 300);
		frmPackageTracer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPackageTracer.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 98, 105, 30);
		frmPackageTracer.getContentPane().add(lblUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(129, 98, 105, 30);
		frmPackageTracer.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel lblLogInOr = new JLabel("Log in/register in order to use the app!");
		lblLogInOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInOr.setBounds(10, 11, 224, 76);
		frmPackageTracer.getContentPane().add(lblLogInOr);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 139, 105, 30);
		frmPackageTracer.getContentPane().add(lblPassword);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(129, 139, 105, 30);
		frmPackageTracer.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				String response = cs.login(username, password);
				if (response.equals("fail")) {
					JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (response.equals("admin")) {
						AdminWindow aw = new AdminWindow(as);
						aw.setVisible(true);
					}
					else {
						ClientWindow cw = new ClientWindow(cs, username);
						cw.setVisible(true);
					}
					frmPackageTracer.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(10, 180, 224, 30);
		frmPackageTracer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				cs.register(username, password);
			}
		});
		btnNewButton_1.setBounds(10, 221, 224, 30);
		frmPackageTracer.getContentPane().add(btnNewButton_1);
	}
	
	public void showLogin() {
		frmPackageTracer.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmPackageTracer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
