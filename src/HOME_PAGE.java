import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HOME_PAGE extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField passL;
	private JTextField txtName;
	private JTextField txtMobile;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JPasswordField passR;
	BusinessLayer bl = new BusinessLayer();
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME_PAGE frame = new HOME_PAGE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HOME_PAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 206, 209));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 742, 52);
		contentPane.add(panel);
		
		JLabel label = new JLabel("HOME PAGE");
		label.setForeground(new Color(255, 99, 71));
		label.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(44, 147, 292, 164);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserId = new JLabel("USER ID :");
		lblUserId.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblUserId.setBackground(Color.LIGHT_GRAY);
		lblUserId.setBounds(25, 24, 79, 34);
		panel_1.add(lblUserId);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblPassword.setBounds(25, 69, 92, 23);
		panel_1.add(lblPassword);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Sitka Small", Font.BOLD, 12));
		txtID.setBounds(151, 32, 126, 20);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		passL = new JPasswordField();
		passL.setBounds(151, 70, 126, 20);
		panel_1.add(passL);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName  = txtID.getText();
				//System.out.println(userName);
				char[] password1 = passL.getPassword();
				String password = new String (password1);
				//System.out.println(password);
				bl.retrive(userName, password);
			}
		});
		btnSubmit.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		btnSubmit.setBounds(28, 116, 89, 23);
		panel_1.add(btnSubmit);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		btnCancel.setBounds(185, 116, 89, 23);
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(391, 147, 292, 235);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		lblName.setBounds(10, 25, 101, 14);
		panel_2.add(lblName);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		lblMobile.setBounds(10, 61, 101, 14);
		panel_2.add(lblMobile);
		
		JLabel lblUserId_1 = new JLabel("USER ID");
		lblUserId_1.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		lblUserId_1.setBounds(10, 94, 101, 14);
		panel_2.add(lblUserId_1);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		lblEmail.setBounds(10, 129, 101, 14);
		panel_2.add(lblEmail);
		
		JLabel lblPassword_1 = new JLabel("PASSWORD");
		lblPassword_1.setFont(new Font("Sitka Heading", Font.BOLD, 12));
		lblPassword_1.setBounds(10, 164, 101, 14);
		panel_2.add(lblPassword_1);
		
		txtName = new JTextField();
		txtName.setBounds(139, 21, 129, 20);
		panel_2.add(txtName);
		txtName.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(139, 57, 129, 20);
		panel_2.add(txtMobile);
		txtMobile.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(139, 90, 129, 20);
		panel_2.add(txtUser);
		txtUser.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(139, 125, 129, 20);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSubmit_1 = new JButton("SUBMIT");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{		
				//Registration Form
				
				String name = txtName.getText();
				String mobile = txtMobile.getText();
				String userId = txtUser.getText();
				String email = txtEmail.getText();
				char[] Rpass = passR.getPassword();
				String Rpass1 = new String(Rpass);  //  convert into string from char array
				bl.insert(name,mobile ,userId ,email ,Rpass1);
			}
		});
		btnSubmit_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnSubmit_1.setBounds(10, 190, 89, 23);
		panel_2.add(btnSubmit_1);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnClear.setBounds(179, 191, 89, 23);
		panel_2.add(btnClear);
		
		passR = new JPasswordField();
		passR.setBounds(139, 160, 129, 20);
		panel_2.add(passR);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(44, 80, 292, 40);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblLoginForm.setBounds(102, 11, 97, 18);
		panel_3.add(lblLoginForm);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(391, 80, 292, 40);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("REGISTRATION FORM");
		lblRegistrationForm.setFont(new Font("Sitka Heading", Font.BOLD, 14));
		lblRegistrationForm.setBounds(68, 11, 142, 18);
		panel_4.add(lblRegistrationForm);
	}
}
