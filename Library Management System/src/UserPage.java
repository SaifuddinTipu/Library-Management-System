import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserPage extends Login{

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage window = new UserPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserPage() {
		UserPageGUI();
	}

	private void UserPageGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Search for Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SearchBook.main(null);
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(108, 108, 207, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Log Out");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login.main(null);
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(108, 209, 207, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblUserPage = new JLabel("User Page");
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(163, 66, 117, 29);
		frame.getContentPane().add(lblUserPage);
		
		JButton btnRequestForBook = new JButton("Request for Book");
		btnRequestForBook.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnRequestForBook.setBounds(108, 142, 207, 23);
		frame.getContentPane().add(btnRequestForBook);
		
		JButton btnComplaints = new JButton("Feedback");
		btnComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Feedback.main(null);
			}
		});
		btnComplaints.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnComplaints.setBounds(108, 175, 207, 23);
		frame.getContentPane().add(btnComplaints);
	}
}
