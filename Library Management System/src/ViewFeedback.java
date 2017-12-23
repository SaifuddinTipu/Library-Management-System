import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ViewFeedback extends Login{

	private JFrame frame;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFeedback window = new ViewFeedback();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewFeedback() {
		ViewFeedbackGUI();
	}

	private void ViewFeedbackGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LibrarianPage.main(null);
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(337, 227, 87, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblUserPage = new JLabel("Feedback");
		lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(122, 60, 179, 29);
		frame.getContentPane().add(lblUserPage);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("Feedback.txt"));
				    
				    String line;
				    
				    textArea.setText(null);
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    		textArea.append(array[0]+"\n");

				    }

				} catch (IOException t) {
				    t.printStackTrace();
				} 
			}
		});
		btnDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnDisplay.setBounds(240, 227, 87, 23);
		frame.getContentPane().add(btnDisplay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 94, 334, 122);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBorder(border);
	}
	
}

