import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		LoginGUI();
		
	}

	public void LoginGUI() {
		frame = new JFrame("Welcome to Library Management System");
		frame.setBounds(100, 100, 450, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel WelcomeToLibrary = new JLabel("Welcome To Library Management System");
		WelcomeToLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeToLibrary.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		WelcomeToLibrary.setBounds(20, 27, 397, 29);
		frame.getContentPane().add(WelcomeToLibrary);
		
		JButton Librarian = new JButton("Librarian");
		Librarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianLogin.main(new String[]{});
				frame.dispose();
			}
		});
		Librarian.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Librarian.setBounds(116, 105, 198, 29);
		frame.getContentPane().add(Librarian);
		
		JLabel LoginPage = new JLabel("Login Page");
		LoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		LoginPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		LoginPage.setBounds(149, 65, 144, 29);
		frame.getContentPane().add(LoginPage);
		
		JButton Vendor = new JButton("Vendor");
		Vendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendorLogin.main(new String[]{});
				frame.dispose();
			}
		});
		Vendor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Vendor.setBounds(116, 145, 198, 29);
		frame.getContentPane().add(Vendor);
		
		JButton RegisteredUser = new JButton("Registered User");
		RegisteredUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin.main(new String[]{});
				frame.dispose();
			}
		});
		RegisteredUser.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		RegisteredUser.setBounds(116, 185, 198, 29);
		frame.getContentPane().add(RegisteredUser);
	
	}
	
}
