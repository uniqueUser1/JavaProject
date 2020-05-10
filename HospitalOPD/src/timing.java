import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class timing implements MouseListener
{
	JFrame jf;
	JTextField docidtxt,docnametxt,doctimetxt;
	JLabel savelab,docidlab,docnamelab,doctimelab,backpiclab;
	Font myfont,f;
	
	
	
	
	public void adddocavl()
	{
		jf=new JFrame("Add Doctor Timings");
		jf.setLayout(null);
		//***** Create All Objects
		
		
		docidtxt=new JTextField();
		docnametxt=new JTextField();
		doctimetxt=new JTextField();
		
		
		docidlab=new JLabel("Doctor ID:");
		docnamelab=new JLabel("Doctor Name:");
		doctimelab=new JLabel("Doctor Timings:");
		try {
			backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/00.jpg"))));
		savelab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}

	
		
		
		myfont=new Font("Comic Sans MS",Font.PLAIN,20);
		f=new Font("Comic Sans MS",Font.PLAIN,10);
			
		//***** Set Bounderies
		
		docidtxt.setBounds(200,20,100,30);
		docnametxt.setBounds(200,80,150,30);
		doctimetxt.setBounds(200,140,150,30);
		
		
		
		docidlab.setBounds(20,20,150,30);
		docnamelab.setBounds(20,80,150,30);
		doctimelab.setBounds(20,140,150,30);
		
		
		backpiclab.setBounds(0,0,380,270);
		savelab.setBounds(250,200,100,30);
		
		
		
		

		
			
		//***** Apply Font
		
		docidtxt.setFont(myfont);
		docnametxt.setFont(myfont);
		doctimetxt.setFont(myfont);
		
	
		
		
		
		docidlab.setFont(myfont);
		docnamelab.setFont(myfont);
		doctimelab.setFont(myfont);
		
		
		
		
		//***** Add all to frame
		jf.add(docidtxt);
		jf.add(docnametxt);
		jf.add(doctimetxt);
		
		
		
		
		
		jf.add(docidlab);
		jf.add(docnamelab);
		jf.add(doctimelab);
		jf.add(savelab);
		
		
		jf.add(backpiclab);
		
		
	    
		savelab.addMouseListener(this);
		//viewbt.addActionListener(this);
				//**** Frame Behavior
		
		
		jf.setVisible(true);
		jf.setSize(380,270);
		jf.setLocation(495,195);
		jf.setResizable(false);

		
	}//Show Admission Frame End
	public void mouseEntered(MouseEvent ae) //overriding
	
	{
		if(ae.getSource()==savelab)
		{
			try{
			savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab2.jpg"))));
			}
			catch(Exception e){}
			}
		
	}
	public void mouseExited(MouseEvent ae)
	{
		if(ae.getSource()==savelab)
		{
			try{savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));}catch(Exception e){}
		}
		
	}
	
	public void mouseClicked(MouseEvent ae)
	{
		

		if(ae.getSource()==savelab)
		{
			boolean flag=true;
			String name=null;
			int  id=0;
			
			String time=doctimetxt.getText();
			
			if(docnametxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name Required","Admin",0);
				flag=false;
			}
			else
			{
				name=docnametxt.getText();
			}
			if(docidtxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "ID Required","Admin",0);
				flag=false;
			}
			else
			{
				id=Integer.parseInt(docidtxt.getText());
				flag=true;
			}
			
			
			
			//File Class is used to represent a physical file doch on Secondary Storage
			
			
			if(flag=true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into othdocavltab values(?,?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,time);
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saved Successfully","Admin",1);
				docidtxt.setText(null);
				docnametxt.setText(null);
				doctimetxt.setText(null);	
				
			}
			catch(Exception e)	{	}
		}
		}
	}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		
		
	
}//Class End










