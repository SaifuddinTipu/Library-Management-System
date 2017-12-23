import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;

public class SearchBook extends Login{

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	Border border = BorderFactory.createLineBorder(Color.GRAY);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook window = new SearchBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchBook() {
		SearchBookGUI();
	}

	private void SearchBookGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(27, 26, 397, 29);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"));
				    String BookID = textField.getText().trim();
				    String BookTitle = textField.getText().trim();
				    String BookAuthor = textField.getText().trim();
				    boolean Search = false;
				    String line;
				    
				    if(textField.getText().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    	if(array[0].equals(BookID) || array[1].equals(BookTitle) || array[2].equals(BookAuthor)){
				    		textArea.append(array[0]+"\n");
				    		textArea_1.append(array[1]+"\n");
				    		textArea_2.append(array[2]+"\n");
				    		Search = true;
				        } 
				    }
				    
				    if(Search == false){
					    JOptionPane.showMessageDialog(frame,"Book not found!","Error!",JOptionPane.ERROR_MESSAGE);
				    }

				} catch (IOException t) {
				    t.printStackTrace();
				} 
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(10, 258, 87, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				UserPage.main(null);
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(322, 258, 87, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblUserPage = new JLabel("Search for Book");
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(138, 63, 174, 29);
		frame.getContentPane().add(lblUserPage);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(10, 230, 204, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 62, 103);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setBorder(border);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(82, 116, 179, 103);
		frame.getContentPane().add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		textArea_1.setBorder(border);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(271, 116, 136, 103);
		frame.getContentPane().add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_2.setViewportView(textArea_2);
		textArea_2.setEditable(false);
		textArea_2.setBorder(border);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblId.setBounds(20, 92, 40, 29);
		frame.getContentPane().add(lblId);
		
		JLabel lblBookTitle = new JLabel("Title");
		lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblBookTitle.setBounds(82, 92, 179, 29);
		frame.getContentPane().add(lblBookTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAuthor.setBounds(271, 92, 136, 29);
		frame.getContentPane().add(lblAuthor);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textArea.setText(null);
				textArea_1.setText(null);
				textArea_2.setText(null);
			}
		});
		btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnClear.setBounds(236, 258, 76, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"));
				    
				    String line;
				    
				    textArea.setText(null);
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    		textArea.append(array[0]+"\n");
				    		textArea_1.append(array[1]+"\n");
				    		textArea_2.append(array[2]+"\n");
				    		
				    }

				} catch (IOException t) {
				    t.printStackTrace();
				} 
			}
		});
		btnDisplayAll.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnDisplayAll.setBounds(107, 258, 119, 23);
		frame.getContentPane().add(btnDisplayAll);
		
		JLabel lblBookId = new JLabel("Book ID / Title / Author");
		lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblBookId.setBounds(213, 225, 211, 29);
		frame.getContentPane().add(lblBookId);
	}
}
