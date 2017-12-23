import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VendorPage extends Login{

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorPage window = new VendorPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VendorPage() {
		VendorPageGUI();
	}

	private void VendorPageGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JLabel lblUserPage = new JLabel("Vendor Page");
		lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(121, 66, 188, 29);
		frame.getContentPane().add(lblUserPage);
		
		JButton button = new JButton("Supply Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SupplyBook.main(null);
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
		button_1.setBounds(108, 142, 207, 23);
		frame.getContentPane().add(button_1);
	}

}
