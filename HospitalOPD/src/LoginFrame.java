import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame implements MouseListener //implements Runnable
{
	JFrame loginframe;
	JButton loginbt;
	JLabel exitlab,headlab,passlab,useridlab,backpiclab,imalab;
	JTextField useridtxt;
	JComboBox<String> usercombo;
	JPasswordField passtxt;
	Font myfont,headfont;
	
	String users[]={"Admin","Others"};

	//JLabel curtime;
	Font f;
	/*public void run()
	{
		showWatch();
	}
	void showWatch()
	{
		//int h=0,m=0,s=0
		
		while(true)
		{
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
			String ct=sdf.format(d);
			curtime.setText(ct);
			
			
			
			
		}
	}*/
	void showLoginFrame()
	{
		loginframe=new JFrame("Login Page");
		loginframe.setLayout(null);
		
		headlab=new JLabel("Hospice care");
		//userlab=new JLabel("User");
		passlab=new JLabel("Password");
		useridlab=new JLabel("User id");
		//usertxt=new JTextField();
		useridtxt=new JTextField();
		usercombo=new JComboBox<String>(users);
		passtxt=new JPasswordField();
		exitlab=new JLabel("Exit");
		//loginbt=new JButton("Login");
		try{
		imalab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/login1.jpg"))));
		exitlab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/38.jpg"))));
		backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/img3.jpg"))));
		}
		catch(Exception e){}
		myfont=new Font("Arial",Font.BOLD,15);
		headfont=new Font("Cooper Black",Font.ITALIC,40);
		
		
		headlab.setBounds(600,20,400,40);
		
		//userlab.setBounds(450,250,80,30);
		//usercombo.setBounds(560,250,200,30);
		
		useridlab.setBounds(520,220,80,30);
		useridtxt.setBounds(630,220,200,30);
		
		passlab.setBounds(520,280,80,30);
		passtxt.setBounds(630,280,200,30);
		
		imalab.setBounds(630,360,100,30);
		exitlab.setBounds(730,360,100,30);
		backpiclab.setBounds(0,0,1556,462);
		
		
		headlab.setFont(headfont);//userlab.setFont(myfont);
		//loginbt.setFont(myfont);
		passlab.setFont(myfont);
		passtxt.setFont(myfont);//usercombo.setFont(myfont);
		useridlab.setFont(myfont);useridtxt.setFont(myfont);
		
		
		headlab.setForeground(new Color(19,126,206));
		
		imalab.addMouseListener(this);
		exitlab.addMouseListener(this);
		
		
		loginframe.add(exitlab);
		loginframe.add(headlab);loginframe.add(passtxt);
		loginframe.add(imalab);//loginframe.add(usercombo);
		//loginframe.add(userlab);
		loginframe.add(passlab);
		loginframe.add(useridlab);loginframe.add(useridtxt);
		loginframe.add(backpiclab);
		
		
		loginframe.setUndecorated(true);
		loginframe.setResizable(false);

		loginframe.setVisible(true);
		loginframe.setLocation(210,120);
		loginframe.setResizable(false);
		
		loginframe.setSize(1000,460);
		f=new Font("Arial",Font.BOLD,40);
		
		
		
		//curtime=new JLabel("");curtime.setFont(f);
		
		
		//curtime.setBounds(890,100,200,40);
		
		
		//loginframe.add(curtime);
		
		
		//Thread t=new Thread(this);
		//t.start();// start method internally calls run
		
	}
	public void mouseEntered(MouseEvent me) //overriding
	
	{
		
		if(me.getSource()==imalab)
		{
			try{imalab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/login2.jpg"))));}catch(Exception e){}
		}
		
		if(me.getSource()==exitlab)
		{
			try{exitlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/381.jpg"))));}catch (Exception e){}
		}
		
	}
	public void mouseExited(MouseEvent me)
	{
		
		if(me.getSource()==imalab)
		{
			try{imalab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/login1.jpg"))));}catch(Exception e){}
		}
		if(me.getSource()==exitlab)
		{
			try{exitlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/38.jpg"))));}catch(Exception e){}
		}
		
	}
	public void mouseClicked(MouseEvent me)
	{

		if(me.getSource()==exitlab)
		{
			
			try
			{
				System.exit(0);
				
			}
			catch(Exception exp)
			{
				
			}
		}
		
		
		if(me.getSource()==imalab)
		{
			String u=useridtxt.getText();
			String p=String.valueOf(passtxt.getPassword());
			System.out.println(u+" "+p);
			try
			{
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from login where username=? and password=?");
				pstmt.setString(1,u);
				pstmt.setString(2,p);
				ResultSet rst=pstmt.executeQuery();
				if(rst.next()) //checks if the given record exists in database or not
				{    
					//JOptionPane.showMessageDialog(null,"Correct "+u, "Admin", 1);	
					loginframe.dispose();
					menuframe mn= new menuframe();
					mn.showMyFrame();
				}
				else
					JOptionPane.showMessageDialog(null,"In-Correct", "Login details", 0);
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}
			
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
}
	
	
		
		

	

