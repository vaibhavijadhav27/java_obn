import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Component;
import java.awt.Dimension;

public class Show_Post {

	public JFrame frame;
	

	/**
	 * Launch the application.
	 */
	
	
	

	/**
	 * Create the application.
	 */
	public Show_Post(int id, int check) {
		int post_id = id;
		initialize(post_id,check);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id, int uid) 
	{
		frame = new JFrame();
		frame.setTitle("The One Byte News - Post");
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		int author = 0;
		String url = "jdbc:mysql://localhost:3306/db_obn";
		String u_name = "root";
		String r_pass = "";
		String query = "SELECT * FROM post WHERE post_id = '"+id+"'";
		
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			Connection con = DriverManager.getConnection(url, u_name, r_pass);
			
			
			Statement st = con.createStatement();
			Statement st2 = con.createStatement();
			Statement st3 = con.createStatement();
			
			ResultSet rs = st2.executeQuery(query);
			
			
			while(rs.next())
			{
				String title = "";
				title = title + rs.getString("title");
				
				String content = "";
				content = content + rs.getString("content");
				
				int post_author = rs.getInt("author_id");
				
				
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				int len = content.length();
				int dimlen = (int) (len/1.2); 
				int role_id = 1;
				
				String query2 = "SELECT * FROM users WHERE user_id = "+rs.getInt("author_id");
				ResultSet rs2 = st.executeQuery(query2);
				
				String query3 = "SELECT * FROM users WHERE user_id = '"+uid+"'";
				ResultSet rs3 = st3.executeQuery(query3);
				
				String name = "";
				String pdate = "";
				pdate = rs.getString("p_date");
				while(rs2.next())
				{
					name = rs2.getString("name");
					
				}
				
				while(rs3.next())
				{
					int role = rs3.getInt("role");
					role_id = role;
				}
				
				
				//name = rs.getString("author_id");
				
				
				JEditorPane editor = new JEditorPane();
				
				editor.setContentType("text/html");
		
				
				editor.setEditable(false);
				editor.setText("<h1>"+title+"</h1>"
						+ "<p>"+content+"</p>"+"<br>"+
						"<h5>Written By -  "+name+" </h5"+
						"<small>"+pdate+"</small>");
				editor.setPreferredSize(new Dimension(400, dimlen));

				panel.add(editor);
				
				JPanel panel2 = new JPanel();
				frame.getContentPane().add(panel2, BorderLayout.SOUTH);
				
				if(post_author == uid || role_id == 0){	
					
					JButton edit = new JButton("Edit");
					JButton del = new JButton("Delete");
					
					
					panel2.add(edit);
					edit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae)
						{
							try
							{
								frame.dispose();
								Edit_View window = new Edit_View(id, uid);
								window.frame.setVisible(true);
								
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
					});
					
					
					
					panel2.add(del);
					del.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae)
						{
							String url = "jdbc:mysql://localhost:3306/db_obn";
							String u_name = "root";
							String r_pass = "";
							String queryq = "DELETE FROM post WHERE post_id = "+id;
							
							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
							}
							catch(Exception exec)
							{
								exec.printStackTrace();
							}
							
							try {
								
								Connection connection = DriverManager.getConnection(url, u_name, r_pass);
								
								Statement statt = connection.createStatement();
								statt.execute(queryq);
								frame.dispose();
								Home_View window = new Home_View(uid);
								window.frame.setSize(600,650);
								window.frame.setVisible(true);
								JOptionPane.showMessageDialog(frame,"Post Deleted!","Success",JOptionPane.OK_OPTION);
								
								
								con.close();
							}	
							catch(SQLException E)
							{
								E.printStackTrace();
							}
							
						}
							
						
					});
					
				}
				JButton back = new JButton("Back");
				
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						try {
							frame.dispose();
							Home_View window = new Home_View(uid);
							window.frame.setSize(600,650);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				panel2.add(back);
				
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		try {
			int id = 15;
			Show_Post window = new Show_Post(id, 1);
			window.frame.setSize(600,600);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}

