import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
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

 public class viewfood implements MouseListener //implements Runnable
{
	JFrame loginframe;
	JLabel savelab,patidlab,patnamelab,mornlab,aftlab,evelab,backpiclab;
	JTextField patidtxt,patnametxt,morntxt,afttxt,evetxt;
	Font myfont,f;
	String picpath;

	public void viewfoodFrame()
	{
		loginframe=new JFrame("Diet Prescribed");
		loginframe.setLayout(null);
		
		try {
			savelab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
		backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/5.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		patidlab=new JLabel("Patient ID:");
		patnamelab=new JLabel("Patient Name:");
		mornlab=new JLabel("Morning:");
		aftlab=new JLabel("Afternoon:");
		evelab=new JLabel("Evening:");
		

		
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		morntxt=new JTextField();
		afttxt=new JTextField();
		evetxt=new JTextField();
		
		
		
		
		
		myfont=new Font("Arial",Font.BOLD,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
		
		
		
		patidlab.setBounds(20,30,100,30);
		patnamelab.setBounds(20,80,130,30);
		mornlab.setBounds(20,160,100,30);
		aftlab.setBounds(20,260,150,30);
		evelab.setBounds(20,360,100,30);	
		savelab.setBounds(250,480,100,30);	

		
		
		
		patidtxt.setBounds(150,30,100,30);
		patnametxt.setBounds(150,80,190,30);
		morntxt.setBounds(20,200,250,50);
		afttxt.setBounds(20,300,250,50);
		evetxt.setBounds(20,400,250,50);

		
		
		
		backpiclab.setBounds(0,0,370,555);
		
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		mornlab.setFont(myfont);
		aftlab.setFont(myfont);
		evelab.setFont(myfont);
		
		
		patidtxt.setFont(f);
		patnametxt.setFont(f);
		morntxt.setFont(f);
		afttxt.setFont(f);
		evetxt.setFont(f);
		
		
		
		
		
		savelab.addMouseListener(this);
		
		
		
		loginframe.add(patidlab);
		loginframe.add(patnamelab);
		loginframe.add(mornlab);
		loginframe.add(aftlab);
		loginframe.add(evelab);
		loginframe.add(savelab);
		

		
		
		loginframe.add(patidtxt);
		loginframe.add(patnametxt);
		loginframe.add(morntxt);
		loginframe.add(afttxt);
		loginframe.add(evetxt);
		
		loginframe.add(backpiclab);
		
		loginframe.setVisible(true);
		loginframe.setLocation(470,110);
		loginframe.setResizable(false);
		loginframe.setSize(370,555);
				
	}
	
	
	public void mouseEntered(MouseEvent me) //overriding
	
	{
		if(me.getSource()==savelab)
		{
			try {
				savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlabpic.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==savelab)
		{
			try {
				savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==savelab)
		{
			boolean flag;
			int id=0;
			if(patidtxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "ID Required","Admin",0);
				flag=false;
			}
			else
			{
				try
				{
					id=Integer.parseInt(patidtxt.getText());
				}
				catch(NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(null, "ID must be numeric","Admin",0);
					flag=false;
				}
				
			}
			
			if(flag=true)
			{
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DBConnection.getDBConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from foodprestab where patid=?");
					pstmt.setInt(1,id);
					ResultSet rst=pstmt.executeQuery();
					if(rst.next())
					{
						patnametxt.setText(rst.getString("patname"));
						morntxt.setText(rst.getString("morn"));
						afttxt.setText(rst.getString("aft"));
						evetxt.setText(rst.getString("eve"));
						
					}
					else
						JOptionPane.showMessageDialog(null,"In-Correct Patient ID", "Admin", 0);
				}
				catch(Exception e)	{e.printStackTrace();	}
			}
		}
		}
			
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
}