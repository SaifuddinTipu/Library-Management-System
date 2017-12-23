import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class UserLogin extends Login {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserLogin() {
		
		UserLoginGUI();
		
	}

	public void UserLoginGUI() {
		frame = new JFrame("Welcome to Library Management System");
		frame.setBounds(100, 100, 450, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel WelcomeToLibrary = new JLabel("Welcome To Library Management System");
		WelcomeToLibrary.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		WelcomeToLibrary.setBounds(27, 27, 397, 29);
		frame.getContentPane().add(WelcomeToLibrary);
		
		JLabel lblLoginOr = new JLabel("Login or");
		lblLoginOr.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblLoginOr.setBounds(108, 97, 59, 29);
		frame.getContentPane().add(lblLoginOr);
		
		JLabel lblRegister = new JLabel("Register an Account");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register.main(new String[]{});
				frame.dispose();
			}
		});
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblRegister.setBounds(173, 97, 173, 29);
		frame.getContentPane().add(lblRegister);
		
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
		txtUserName.setBounds(108, 135, 228, 27);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setBounds(108, 173, 228, 27);
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
					BufferedReader Reader = new BufferedReader(new FileReader("UserDatabase.txt"));
				    String username = txtUserName.getText().trim();
				    String password = new String(passwordField.getPassword());
				    
				    String line;
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    	if(array[0].equals(username) && array[1].equals(password)){
				    		JOptionPane.showMessageDialog(frame,"Welcome to Library Management System"); 
				    		UserPage.main(null);
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
		btnLogin.setBounds(118, 208, 102, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel UserLogin = new JLabel("User Login");
		UserLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		UserLogin.setBounds(169, 62, 117, 29);
		frame.getContentPane().add(UserLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnBack.setBounds(230, 208, 102, 23);
		frame.getContentPane().add(btnBack);
	
	}
	
}
