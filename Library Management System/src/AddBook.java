import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class AddBook extends Login{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddBook() {
		AddBookGUI();
	}

	private void AddBookGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JButton btnAddForBook = new JButton("Add Book");
		btnAddForBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File log = new File("BookDatabase.txt");
				
			    String BookID = textField.getText().trim();
			    String BookTitle = textField_1.getText().trim();
			    String BookAuthor = textField_2.getText().trim();
			    String line;
			    
			    try {
			    	@SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("UserDatabase.txt"));
			    	
			    	if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
					while((line = Reader.readLine())!= null){
						String[] array = line.split(",");
						
						if(array[0].equals(BookID) || array[1].equals(BookTitle) || array[2].equals(BookAuthor)){
							JOptionPane.showMessageDialog(frame,"Book existed!","Error!",JOptionPane.ERROR_MESSAGE);
							return;
					    }
						
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			    
						try{
						    if(!log.exists()){
						        log.createNewFile();
						    }
						    
						    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
						    bufferedWriter.write(BookID + "," + BookTitle + "," + BookAuthor);
						    bufferedWriter.newLine();
						    bufferedWriter.close();
						    JOptionPane.showMessageDialog(frame,"Book is added!");

						} catch(IOException n) {
						}
			}
		});
		btnAddForBook.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAddForBook.setBounds(74, 215, 148, 23);
		frame.getContentPane().add(btnAddForBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LibrarianPage.main(null);
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnBack.setBounds(232, 215, 123, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblUserPage = new JLabel("Add Book");
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(165, 66, 178, 29);
		frame.getContentPane().add(lblUserPage);
		
		textField = new JTextField();
		textField.setBounds(130, 107, 178, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 141, 178, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 172, 178, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblId.setBounds(74, 101, 46, 29);
		frame.getContentPane().add(lblId);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblTitle.setBounds(74, 135, 46, 29);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAuthor.setBounds(50, 166, 84, 29);
		frame.getContentPane().add(lblAuthor);
		
	}

}
