import java.awt.EventQueue;
import java.awt.BorderLayout;

import com.mysql.cj.jdbc.Driver;

import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.*;


import java.awt.*;
import java.sql.*;
public class Edit_View {

	public JFrame frame;
	private JTextField textField;
	//private final JLabel lblNewLabel_6 = new JLabel("THE ONE \r\nBYTE NEWS");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					int id = 17;
					Edit_View window = new Edit_View(id,1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}

	/**
	 * Create the application.
	 */
	public Edit_View(int post_id, int uid) {
		initialize(post_id,uid);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(int post_id, int uid) {

		frame = new JFrame();
		frame.setTitle("The One Byte News - Edit");
		//frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 705, 551);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CREATE POST");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(53, 67, 161, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_2.setBounds(53, 100, 60, 32);
		frame.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(53, 129, 493, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Section");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(60, 190, 80, 25);
		frame.getContentPane().add(lblNewLabel_4);

		String[] sections = { "Vlogs", "News", "Hello", "Tech", "Fun" };
		JComboBox comboBox = new JComboBox(sections);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"News","Hardware","Software"}));
		comboBox.setFont(new Font("Calibri", Font.BOLD, 16));
		comboBox.setBounds(150, 190, 101, 32);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("Content");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_5.setBounds(60, 225, 96, 32);
		frame.getContentPane().add(lblNewLabel_5);

		TextArea textArea = new TextArea();
		textArea.setBounds(60, 263, 493, 193);
		frame.getContentPane().add(textArea);

		JButton postButton = new JButton("SUBMIT");
		postButton.setBackground(Color.WHITE);
		postButton.setForeground(Color.BLACK);
		postButton.setFont(new Font("Calibri", Font.BOLD, 12));
		postButton.setBounds(195, 492, 85, 21);
		frame.getContentPane().add(postButton);
		/*lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(43, 10, 265, 36);
		frame.getContentPane().add(lblNewLabel_6);*/

		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton_1.setBounds(357, 490, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		//Connection parameters
		String url = "jdbc:mysql://localhost:3306/db_obn";
		String u_name = "root";
		String r_pass = "";
	
		
		
		
		String querysel = "SELECT * FROM post WHERE post_id = "+post_id;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		
		try
		{
			Connection con = DriverManager.getConnection(url, u_name, r_pass);
			
			Statement sta = con.createStatement();
			ResultSet res = sta.executeQuery(querysel);
			
			while(res.next())
			{
				String otitle = res.getString("title");
				textField.setText(otitle);
				
				if(res.getString("section") == "News")
				{
					comboBox.setSelectedIndex(0);
				}
				else if(res.getString("section") == "Software")
				{
					comboBox.setSelectedIndex(2);
				}
				else
					comboBox.setSelectedIndex(1);
				
				String ocontent = res.getString("content");
				textArea.setText(ocontent);
				
			}
			
			con.close();
		}
		catch(SQLException exep)
		{
			exep.getStackTrace();
		}
		
		
		postButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
			
				
				String title = textField.getText();
				String section = (String) comboBox.getSelectedItem();
				String content = textArea.getText();
				
				String query = "UPDATE post SET title ='"+title+"', section = '"+section+"', content = '"+content+"' WHERE post_id = '"+post_id+"'";
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
				
				try
				{
					//Connection parameters
					String url = "jdbc:mysql://localhost:3306/db_obn";
					String u_name = "root";
					String r_pass = "";
					Connection connect = DriverManager.getConnection(url, u_name, r_pass);
					
					Statement stat = connect.createStatement();
					stat.execute(query);
					
					try {
						frame.dispose();
						Home_View window = new Home_View(uid);
						window.frame.setVisible(true);
						window.frame.setSize(600,650);
						window.frame.setVisible(true);
						JOptionPane.showMessageDialog(frame,"Post Updated!","Success",JOptionPane.OK_OPTION);
					} catch (Exception exep) {
						exep.printStackTrace();
					}
					
					connect.close();
				}
				catch(SQLException exep)
				{
					exep.getStackTrace();
				}
				
				
				
			}
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					frame.dispose();
					Home_View window = new Home_View(uid);
					window.frame.setVisible(true);
					window.frame.setSize(600,650);
					window.frame.setVisible(true);
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		

	}
}