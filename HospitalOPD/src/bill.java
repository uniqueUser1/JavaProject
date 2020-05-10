import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
public class bill implements MouseListener
{
	JFrame jf;
	JTextField patidtxt,patnametxt,billtxt;
	JLabel backlab,datelab,patidlab,patnamelab,billlab,nxtaptlab,savelab,printlab,paylab;//curtime,curdate;
	JDateChooser dc,pd;
	
	Font myfont,f,f2;
	JRadioButton cashrb,cheqrb,ddrb;
	ButtonGroup paymntgrp;
	
	
	public void addbilldtl()
	{
		jf=new JFrame("Bill");
		jf.setLayout(null);
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		billtxt=new JTextField();
		
		patidlab=new JLabel("Patient ID:");
		patnamelab=new JLabel("Patient Name:");
		billlab=new JLabel("Billing Amount:");
		nxtaptlab=new JLabel("Next Appointment:");
		paylab=new JLabel("Select Payment Mode:");
		datelab=new JLabel("Date:");
		
		try{
			backlab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/19.jpg"))));
			savelab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));
			}
			catch(Exception e){}
		
		dc=new JDateChooser();
		pd=new JDateChooser(new java.util.Date());
		
		cashrb=new JRadioButton("Cash",true);
		cheqrb=new JRadioButton("Cheque");
		ddrb=new JRadioButton("Demand Draft");
		paymntgrp=new ButtonGroup();
		
		paymntgrp.add(cashrb);
		paymntgrp.add(cheqrb);
		paymntgrp.add(ddrb);
		
		cashrb.setOpaque(false);
		cheqrb.setOpaque(false);
		ddrb.setOpaque(false);
		
		myfont=new Font("Comic Sans MS",Font.PLAIN,20);
		f=new Font("Comic Sans MS",Font.BOLD,10);
		f2=new Font("Comic Sans MS",Font.PLAIN,15);
		
		patidtxt.setBounds(150,30,100,30);
		patnametxt.setBounds(170,110,200,30);
		
		patidlab.setBounds(20,20,100,50);
		patnamelab.setBounds(20,100,130,50);
		datelab.setBounds(20,180,80,50);
		
		pd.setBounds(120,190,100,30);
		
		nxtaptlab.setBounds(250,180,140,50);
		
		dc.setBounds(410,190,100,30);

		paylab.setBounds(20,260,250,50);
		
		
		cashrb.setBounds(20,330,100,30);
		cheqrb.setBounds(150,330,100,30);
		ddrb.setBounds(280,330,150,30);
		
		
		billlab.setBounds(20,390,150,50);
		billtxt.setBounds(200,400,110,30);
		
	    savelab.setBounds(410,450,100,50);
	    backlab.setBounds(0,0,540,540);
	    
		patidtxt.setFont(f2);
		patnametxt.setFont(f2);
		billtxt.setFont(f2);
		
		cashrb.setFont(f2);
		cheqrb.setFont(f2);
		ddrb.setFont(f2);
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		billlab.setFont(myfont);
		nxtaptlab.setFont(myfont);
		paylab.setFont(myfont);
		datelab.setFont(myfont);

		jf.add(patidtxt);
		jf.add(patnametxt);
		jf.add(billtxt);
		
		
		
		jf.add(patidlab);
		jf.add(patnamelab);
		jf.add(billlab);
		jf.add(nxtaptlab);
		jf.add(savelab);
		
		jf.add(paylab);
		jf.add(datelab);
				
		
	    jf.add(cashrb);
	    jf.add(cheqrb);
	    jf.add(ddrb);
	    
	    jf.add(dc);
	    jf.add(pd);
	    
	    
	  jf.add(backlab);

	    //jf.add(curtime);
	    //jf.add(curdate);
		
		
		savelab.addMouseListener(this);
		//viewbt.addActionListener(this);
		//browsesnap.addActionListener(this);
		
		//**** Frame Behavior
		
		
		jf.setVisible(true);
		jf.setSize(540,540);
		jf.setLocation(400,80);
		jf.setResizable(false);
		
	}//Show Admission Frame End
	
public void mouseEntered(MouseEvent ae) //overriding
	
	{
		
	if(ae.getSource()==savelab)
	{
		try{savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab2.jpg"))));}catch(Exception e){}
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
			
			int  id=0;
			int bill=0;
			
			String name=patnametxt.getText();
			
			if(billtxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Billing Amount Required","Admin",0);
				flag=false;
			}
			else
			{
				bill=Integer.parseInt(billtxt.getText());
				flag=true;
			}
			if(patidtxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "ID Required","Admin",0);
				flag=false;
			}
			else
			{
				try{id=Integer.parseInt(patidtxt.getText());}
				catch(NumberFormatException exp){}
				
			}
			String mode=null;
			if(cheqrb.isSelected())
				mode="Cheque";
			else if(cashrb.isSelected())
				mode="Cash";
			else if(ddrb.isSelected())
				mode="Demand Draft";
			
			Date dob=dc.getDate();
			String dobstr="";
			if(dob==null)
			{
				JOptionPane.showMessageDialog(null, "Date Required","Admin",0);
				flag=false;
			}
			else{
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMMM-yyyy");
			dobstr=sdf1.format(dob);}
			
			Date dob1=pd.getDate();
			
			String dobstr1="";
			if(dob1==null)
			{
				JOptionPane.showMessageDialog(null, "Date Required","Admin",0);
				flag=false;
			}
			else{
			SimpleDateFormat sdf2=new SimpleDateFormat("dd-MMMM-yyyy");
			dobstr1=sdf2.format(dob1);}
			
			if(flag==true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into billtab values(?,?,?,?,?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,dobstr1);
				pstmt.setString(4,dobstr);
				pstmt.setString(5,mode);
				pstmt.setInt(6,bill);
				
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saved Successfully","Admin",1);
				patidtxt.setText(null);
				patnametxt.setText(null);
				
				
				
				billtxt.setText(null);
				}
			catch(Exception e)	{	}}
		}
		
	}
	public void mousePressed(MouseEvent ae){}
	public void mouseReleased(MouseEvent ae){}
	
}



