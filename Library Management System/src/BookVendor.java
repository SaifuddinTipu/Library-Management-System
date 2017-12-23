import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class BookVendor extends Login{

	private JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookVendor window = new BookVendor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookVendor() {
		BookVendorGUI();
	}

	private void BookVendorGUI() {
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
		
		JLabel lblUserPage = new JLabel("Book from Vendor");
		lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblUserPage.setBounds(122, 60, 179, 29);
		frame.getContentPane().add(lblUserPage);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 62, 99);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setBorder(border);
		Border border2 = BorderFactory.createLineBorder(Color.GRAY);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(82, 118, 179, 99);
		frame.getContentPane().add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		textArea_1.setBorder(border2);
		Border border3 = BorderFactory.createLineBorder(Color.GRAY);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(271, 118, 136, 98);
		frame.getContentPane().add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_2.setViewportView(textArea_2);
		textArea_2.setEditable(false);
		textArea_2.setBorder(border3);
		
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
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    @SuppressWarnings("resource")
					BufferedReader Reader = new BufferedReader(new FileReader("SupplyDatabase.txt"));
				    
				    String line;
				    
				    textArea.setText(null);
				    textArea_1.setText(null);
				    textArea_2.setText(null);
				    
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
		btnDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnDisplay.setBounds(239, 227, 87, 23);
		frame.getContentPane().add(btnDisplay);
	}

}
