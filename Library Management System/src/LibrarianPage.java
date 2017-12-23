import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibrarianPage extends Login {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianPage window = new LibrarianPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibrarianPage() {
		LibrarianPageGUI();
	}

	private void LibrarianPageGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JLabel lblUserPage = new JLabel("Librarian Page");
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(145, 66, 188, 29);
		frame.getContentPane().add(lblUserPage);
		
		JButton button = new JButton("Add Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AddBook.main(null);
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(108, 99, 207, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Log Out");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login.main(null);
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(108, 227, 207, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnTracking = new JButton("View Book from Vendor");
		btnTracking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				BookVendor.main(null);
			}
		});
		btnTracking.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnTracking.setBounds(108, 159, 207, 23);
		frame.getContentPane().add(btnTracking);
		
		JButton btnViewFeedback = new JButton("View Feedback");
		btnViewFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewFeedback.main(null);
			}
		});
		btnViewFeedback.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnViewFeedback.setBounds(108, 193, 207, 23);
		frame.getContentPane().add(btnViewFeedback);
		
		JButton btnEditBook = new JButton("Edit Book");
		btnEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EditBook.main(null);
			}
		});
		btnEditBook.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEditBook.setBounds(108, 130, 207, 23);
		frame.getContentPane().add(btnEditBook);
	}
}
