import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;

public class EditBook extends Login{

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JTextArea textArea_5;
	Border border = BorderFactory.createLineBorder(Color.GRAY);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBook window = new EditBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditBook() {
		EditBookGUI();
	}

	private void EditBookGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome To Library Management System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(10, 24, 397, 29);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"));
				    String BookID = textField.getText().trim();
				    boolean Search = false;
				    String line;
				    
				    if(textField.getText().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
				    
				    while((line = Reader.readLine())!= null){
				    	String[] array = line.split(",");
				    	
				    	if(array[0].equals(BookID)){
				    		textArea.append(array[0]+"\n");
				    		textArea_1.append(array[1]+"\n");
				    		textArea_2.append(array[2]+"\n");
				    		textArea_3.append(array[0]+"\n");
				    		textArea_4.append(array[1]+"\n");
				    		textArea_5.append(array[2]+"\n");
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
		button.setBounds(20, 258, 87, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LibrarianPage.main(null);
			}
		});
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(300, 258, 87, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblUserPage = new JLabel("Edit Book");
		lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(115, 58, 174, 29);
		frame.getContentPane().add(lblUserPage);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(10, 219, 204, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 117, 60, 27);
		frame.getContentPane().add(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBorder(border);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(84, 117, 177, 27);
		frame.getContentPane().add(textArea_1);
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea_1.setEditable(false);
		textArea_1.setBorder(border);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(273, 117, 134, 27);
		frame.getContentPane().add(textArea_2);
		textArea_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
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
				textArea_3.setText(null);
				textArea_4.setText(null);
				textArea_5.setText(null);
			}
		});
		btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnClear.setBounds(214, 258, 76, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblBookId.setBounds(213, 219, 87, 29);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblNewId = new JLabel("New ID");
		lblNewId.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewId.setBounds(10, 151, 62, 29);
		frame.getContentPane().add(lblNewId);
		
		textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea_3.setBounds(11, 176, 60, 27);
		textArea_3.setBorder(border);
		frame.getContentPane().add(textArea_3);
		
		JLabel lblNewTitle = new JLabel("New Title");
		lblNewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewTitle.setBounds(82, 151, 179, 29);
		frame.getContentPane().add(lblNewTitle);
		
		textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea_4.setBounds(83, 176, 177, 27);
		textArea_4.setBorder(border);
		frame.getContentPane().add(textArea_4);
		
		JLabel lblNewAuthor = new JLabel("New Author");
		lblNewAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewAuthor.setBounds(271, 151, 136, 29);
		frame.getContentPane().add(lblNewAuthor);
		
		textArea_5 = new JTextArea();
		textArea_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea_5.setBounds(272, 176, 134, 27);
		textArea_5.setBorder(border);
		frame.getContentPane().add(textArea_5);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

            	String BookID = textArea_3.getText().trim();
            	String BookTitle = textArea_4.getText().trim();
            	String BookAuthor = textArea_5.getText().trim();
	            String oldData = "";
	            String line = "";
	            String info = String.format(BookID + "," + BookTitle + "," + BookAuthor);
	            
				try (BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"))){

		            while ((line = Reader.readLine()) != null) {
		                oldData += line + System.getProperty("line.separator");
		            }
		            
				} catch (Exception a1){
					a1.printStackTrace();
				}
		           
				try (BufferedReader BReader = new BufferedReader(new FileReader("BookDatabase.txt"))){
				
		            while ((line = BReader.readLine()) != null) {
		                String array[] = line.split(",");
		                
		                if(array[0].equals(BookID))
		                {
		                	String oldInfo = String.format(array[0] + "," + array[1] + "," + array[2]);
		                	String newData = oldData.replaceAll(oldInfo, info);
		                	FileWriter FWriter = new FileWriter("BookDatabase.txt");
		                	BufferedWriter BWriter = new BufferedWriter(FWriter);
		                	BWriter.write(newData);
		                	BWriter.close();
		                	JOptionPane.showMessageDialog(null, "Book is updated!","Update Book",JOptionPane.INFORMATION_MESSAGE);
		                }
		            }
		            
				} catch (Exception a){
					a.printStackTrace();
				}
		            
		}});
		btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnUpdate.setBounds(117, 258, 87, 23);
		frame.getContentPane().add(btnUpdate);
	}

}
