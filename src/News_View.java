import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import java.sql.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;



public class News_View {

	final static boolean shouldFill = true;  
	final static boolean shouldWeightX = true;  
	final static boolean RIGHT_TO_LEFT = false;  

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			News_View window = new News_View(0);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the application.
	 */
	public News_View(int check) {
		initialize(check);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int check) {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 542);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("The One Byte Show - News");

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);


		//Connection parameters
		String url = "jdbc:mysql://localhost:3306/db_obn";
		String u_name = "root";
		String r_pass = ""; 
		String query = "SELECT * FROM post WHERE section = 'News' ORDER BY p_date DESC";
		String uname = "";
		String query2 = "SELECT * FROM users WHERE user_id = '"+check+"'";
		int i = 10;

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
			ResultSet rs = st.executeQuery(query);

			Statement st2 = con.createStatement();

			ResultSet rs2 = st2.executeQuery(query2);

			//Nav

			JButton button1, button2, button3, button4;  

			if (shouldFill) {  
				//natural height, maximum width  
				c.fill = GridBagConstraints.HORIZONTAL;  
			}  

			button1 = new JButton("Home");  
			if (shouldWeightX) {  
				c.weightx = 0.5;  
			}  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.gridx = 0;  
			c.gridy = 0;
			panel.add(button1, c);

			button1.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					if(check != 0) {
						try {
							frame.dispose();
							Home_View window = new Home_View(check);
							window.frame.setVisible(true);
							window.frame.setSize(600,650);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
					else {
						try {
							frame.dispose();
							Home_View window = new Home_View(0);
							window.frame.setSize(600,650);
							window.frame.setVisible(true);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
					//window.frame.setVisible(true);
				}  
			}); 


			button2 = new JButton("News");  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.weightx = 0.5;
			c.gridx = 1;  
			c.gridy = 0;  
			panel.add(button2, c);
			button2.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					if(check != 0) {
						try {
							frame.dispose();
							News_View window = new News_View(check);
							window.frame.setVisible(true);
							window.frame.setSize(600, 350);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
					else {
						try {
							frame.dispose();
							News_View window = new News_View(0);
							window.frame.setSize(600,350);
							window.frame.setVisible(true);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
				}  
			}); 

			button3 = new JButton("Software");  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.weightx = 0.5;  
			c.gridx = 2;  
			c.gridy = 0;  
			panel.add(button3, c); 
			button3.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					if(check != 0) {
						try {
							frame.dispose();
							Software_View window = new Software_View(check);
							window.frame.setVisible(true);
							window.frame.setSize(600,350);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
					else {
						try {
							frame.dispose();
							Software_View window = new Software_View(0);
							window.frame.setSize(600,350);
							window.frame.setVisible(true);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
				}  
			}); 

			button4 = new JButton("Hardware");  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.weightx = 0.5;  
			c.gridx = 3;  
			c.gridy = 0;  
			panel.add(button4, c); 
			button4.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
					if(check != 0) {
						try {
							frame.dispose();
							Hardware_View window = new Hardware_View(check);
							window.frame.setVisible(true);
							window.frame.setSize(600,250);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
					else {
						try {
							frame.dispose();
							Hardware_View window = new Hardware_View(0);
							window.frame.setSize(600,250);
							window.frame.setVisible(true);
						} catch (Exception exep) {
							exep.printStackTrace();
						}}
				}    
			}); 


			while(rs.next())
			{
				String data = "";
				data = data + rs.getString("title");
				JButton post = new JButton(data); 
				i = i + 2;
				c.fill = GridBagConstraints.HORIZONTAL;  
				c.ipady = 30;      //make this component tall  
				c.weightx = 0.0;  
				c.gridwidth = 4;  
				c.gridx = 0;  
				c.gridy = i;  

				panel.add(post, c);
				//System.out.println(data);
				int post_id = rs.getInt("post_id");

				post.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
						frame.dispose();
						Show_Post window = new Show_Post(post_id, check);
						window.frame.setSize(600,600);
						window.frame.setVisible(true);
					}  
				}); 

			}
			
			while(rs2.next())
			{
				uname = rs2.getString("name");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}


		if(check != 0){	
			i = i+1;
			JLabel name = new JLabel(uname);
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.ipady = 0;       //reset to default  
			c.weighty = 1.0;   //request any extra vertical space  
			c.anchor = GridBagConstraints.PAGE_END; //bottom of space  
			c.insets = new Insets(10,0,0,0);  //top padding  
			c.gridx = 0;       //aligned with button 2  
			c.gridwidth = 2;   //2 columns wide  
			c.gridy = i;       //third row
			panel.add(name,c);
			JButton create = new JButton("Create Post");  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.ipady = 0;       //reset to default  
			c.weighty = 1.0;   //request any extra vertical space  
			c.anchor = GridBagConstraints.PAGE_END; //bottom of space  
			c.insets = new Insets(10,0,0,0);  //top padding  
			c.gridx = 1;       //aligned with button 2  
			c.gridwidth = 2;   //2 columns wide  
			c.gridy = i;       //third row  
			panel.add(create, c);

			JButton logout = new JButton("Logout");  
			c.fill = GridBagConstraints.HORIZONTAL;  
			c.ipady = 0;       //reset to default  
			c.weighty = 1.0;   //request any extra vertical space  
			c.anchor = GridBagConstraints.PAGE_END; //bottom of space  
			c.insets = new Insets(10,0,0,0);  //top padding  
			c.gridx = 3;       //aligned with button 2  
			c.gridwidth = 2;   //2 columns wide  
			c.gridy = i;       //third row  
			panel.add(logout, c);


			create.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try {
						frame.dispose();
						Create_Post window = new Create_Post(check);
						window.frame.setVisible(true);
					}
					catch(Exception exep)
					{
						exep.printStackTrace();
					}
				}
			});

			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try {
						frame.dispose();
						Home_View window = new Home_View(0);
						window.frame.setSize(600,650);
						window.frame.setVisible(true);
					} catch (Exception exep) {
						exep.printStackTrace();
					}
				}
			});


		}
	}

}



