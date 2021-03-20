import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;

public class Login_View{
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordlabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JButton button2;
	private static JLabel success;
	public JFrame frame;
	private JLabel lblNewLabel;
	

	public Login_View()
	{
		initialize();
	}
	
	public void initialize(){
		
		frame = new JFrame();
		frame.setTitle("The One Byte News - Login");
		JPanel panel = new JPanel();
		//panel.setBackground(Color.DARK_GRAY);
		
		frame.setSize(450,300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Email-Id");
		userLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		userLabel.setForeground(Color.BLACK);
		userLabel.setBounds(10,49,80,25);
		panel.add(userLabel);
		
		userText = new JTextField(30);
		userText.setBounds(100, 48, 250,25);
		panel.add(userText);
		
		passwordlabel = new JLabel("Password");
		passwordlabel.setForeground(Color.BLACK);
		passwordlabel.setFont(new Font("Calibri", Font.BOLD, 18));
		passwordlabel.setBounds(10,95,80,25);
		panel.add(passwordlabel);
		
	    passwordText = new JPasswordField();
		passwordText.setBounds(100,94,250,25);
		panel.add(passwordText);
		
	    button = new JButton("Login");
		button.setBounds(10,143,80,25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = userText.getText();
				String password = passwordText.getText();
				
				//Connection parameters
				String url = "jdbc:mysql://localhost:3306/db_obn";
				String u_name = "root";
				String r_pass = "";
				String query = "SELECT * FROM users WHERE email_id = '"+email+"' AND password = '"+password+"'";
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				}
				catch(Exception exec)
				{
					exec.printStackTrace();
				}
				
				try {
					
					Connection con = DriverManager.getConnection(url, u_name, r_pass);
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					
					if(rs.next())
					{
						int id = Integer.parseInt(rs.getString("user_id"));
						frame.dispose();
						Home_View window = new Home_View(id);
						window.frame.setSize(600,650);
						window.frame.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Email Address or Password is Incorrect.","Alert",JOptionPane.WARNING_MESSAGE);
						userText.setText("");
						passwordText.setText("");
					}
					
					con.close();
				}
				catch(SQLException s)
				{
					s.printStackTrace();
				}
				
			}
		});
		
		
		button2 = new JButton("Clear");
		button2.setBounds(116,143,80,25);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				userText.setText("");
				passwordText.setText("");
			}
		});
		panel.add(button);
		panel.add(button2);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);			
		
		lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(20, 10, 263, 29);
		panel.add(lblNewLabel);
		
			
		frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args)
	{
		
		try {
			Login_View window = new Login_View();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}