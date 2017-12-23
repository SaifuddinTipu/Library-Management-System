import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Feedback extends Login{

	private JFrame frame;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback window = new Feedback();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Feedback() {
		FeedbackGUI();
	}


	private void FeedbackGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File log = new File("Feedback.txt");
				
			    String Feedback = textArea.getText().trim();
			    
			    if(textArea.getText().isEmpty()){
			    	JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
		    		return;
			    }
						try{
						    if(!log.exists()){
						        log.createNewFile();
						    }
						    
						    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
						    bufferedWriter.write(Feedback);
						    bufferedWriter.newLine();
						    bufferedWriter.close();
						    JOptionPane.showMessageDialog(frame,"Thanks for your feedback!");

						} catch(IOException n) {
						}
			}
		});
		btnSubmit.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnSubmit.setBounds(84, 215, 131, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				UserPage.main(null);
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnBack.setBounds(222, 215, 125, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblUserPage = new JLabel("Feedback");
		lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(160, 60, 117, 29);
		frame.getContentPane().add(lblUserPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 95, 330, 109);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
