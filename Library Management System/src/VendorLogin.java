import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VendorLogin extends Login{

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private JButton btnBack;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorLogin window = new VendorLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VendorLogin() {
		
		VendorLoginGUI();
		
	}

	public void VendorLoginGUI() {
		frame = new JFrame("Welcome to Library Management System");
		frame.setBounds(100, 100, 450, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel WelcomeToLibrary = new JLabel("Welcome To Library Management System");
		WelcomeToLibrary.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		WelcomeToLibrary.setBounds(27, 27, 397, 29);
		frame.getContentPane().add(WelcomeToLibrary);
		
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUserName.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().isEmpty()){
					txtUserName.setText("User Name");
				}
			}
		});
		txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtUserName.setText("User Name");
		txtUserName.setBounds(109, 118, 228, 27);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setBounds(109, 156, 228, 27);
		char passwordChar; 
		passwordChar = passwordField.getEchoChar(); 
		passwordField.setEchoChar((char) 0); 
		passwordField.setText("Password");
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
				passwordField.setEchoChar(passwordChar); 
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getPassword().length == 0){
					passwordField.setText("Password");
					passwordField.setEchoChar((char) 0);
			}
		}
		});
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("VendorDatabase.txt"));
				    String username = txtUserName.getText().trim();
				    String password = new String(passwordField.getPassword());
				    
				    String line;
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    	if(array[0].equals(username) && array[1].equals(password)){
				    		JOptionPane.showMessageDialog(frame,"Welcome to Library Management System");
				    		VendorPage.main(null);
				    		frame.dispose();
				    		return;
				        }

				    }

				    JOptionPane.showMessageDialog(frame,"Invalid Username or Password","Error!",JOptionPane.ERROR_MESSAGE);

				} catch (IOException t) {
				    t.printStackTrace();
				} 
			}
		});
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnLogin.setBounds(119, 194, 102, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel VendorLogin = new JLabel("Vendor Login");
		VendorLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		VendorLogin.setBounds(153, 65, 147, 29);
		frame.getContentPane().add(VendorLogin);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnBack.setBounds(231, 194, 102, 23);
		frame.getContentPane().add(btnBack);
	
	}
	
}
