import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class addpat implements ActionListener
{
	JFrame jf;
	JTextField patidtxt,patnametxt,patphtxt,patprobtxt,patagetxt;
	JLabel headlab,patidlab,patnamelab,patphlab,pataddrlab,patproblab,patagelab,backpiclab,imglab;
	JButton browsesnap,savebt,medbt,foodbt;
	Font myfont,f;
	JRadioButton malerb,femalerb;
	ButtonGroup gendergrp;
	JScrollPane jsp;
	JTextArea pataddrtxt;
	
	String picpath;
	
	public void addpatdtl()
	{
		jf=new JFrame("Add Patient Details");
		jf.setLayout(null);
		//***** Create All Objects
		
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		patphtxt=new JTextField();
		patagetxt=new JTextField();
		patprobtxt=new JTextField();
		
		pataddrtxt=new JTextArea();
		
		jsp=new JScrollPane(pataddrtxt);
		
		patidlab=new JLabel("Patient ID:");
		patnamelab=new JLabel("Patient Name:");
		patphlab=new JLabel("Patient Contact:");
		patagelab=new JLabel("Patient Age:");
		pataddrlab=new JLabel("Patient Address:");
		patproblab=new JLabel("Patient Problem:");
		headlab=new JLabel("Add Patient Details:");
		
		try{
			backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/addpatback.jpg"))));}
			catch(Exception e){}

		
		imglab=new JLabel();
		
		malerb=new JRadioButton("male",true);
		femalerb=new JRadioButton("female");
		gendergrp=new ButtonGroup();
		
		gendergrp.add(malerb);
		gendergrp.add(femalerb);
		
		malerb.setOpaque(false);
		femalerb.setOpaque(false);

		
		imglab.setBorder(new LineBorder(Color.BLACK,1));//Color,Thickness
		
		browsesnap=new JButton("Browse Snap");
		savebt=new JButton("Save");
		medbt=new JButton("Medicines Prescribed");
		foodbt=new JButton("Diet Prescribed");
		
		myfont=new Font("Comic Sans MS",Font.PLAIN,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
			
		//***** Set Bounderies
		
		patidtxt.setBounds(200,80,150,30);
		patnametxt.setBounds(200,150,200,30);
		patphtxt.setBounds(200,240,150,30);
		//pataddrtxt.setBounds(180,300,200,40);
		patprobtxt.setBounds(200,420,125,30);
		patagetxt.setBounds(200,510,200,30);
		
		patidlab.setBounds(20,70,150,50);
		patnamelab.setBounds(20,140,150,50);
		patphlab.setBounds(20,230,150,50);
		pataddrlab.setBounds(20,320,150,50);
	    patproblab.setBounds(20,410,150,50);
		patagelab.setBounds(20,500,150,50);
		headlab.setBounds(200,10,400,50);
		
		jsp.setBounds(200,330,250,70);

		
		imglab.setBounds(500,80,120,150);
		
		
		malerb.setBounds(20,590,130,30);
		femalerb.setBounds(160,590,150,30);
		
		
		savebt.setBounds(500,600,120,30);
		medbt.setBounds(500,500,120,30);
		foodbt.setBounds(500,550,120,30);
		browsesnap.setBounds(500,250,120,30);
		
		backpiclab.setBounds(0,0,1000,720);

		
		//backpiclab.setBounds(0,0,1000,720);
		
		//***** Apply Font
		patidtxt.setFont(f);
		patnametxt.setFont(f);
		patphtxt.setFont(f);
		pataddrtxt.setFont(f);
		patprobtxt.setFont(f);
		patagetxt.setFont(f);
		
		malerb.setFont(myfont);
		femalerb.setFont(myfont);
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		patphlab.setFont(myfont);
		pataddrlab.setFont(myfont);
		patproblab.setFont(myfont);
		patagelab.setFont(myfont);
		headlab.setFont(myfont);
		
		headlab.setForeground(Color.RED);
		
		
		savebt.setFont(f);
		browsesnap.setFont(f);
		medbt.setFont(f);
		foodbt.setFont(f);
		
		
		
		//***** Add all to frame
		jf.add(patidtxt);
		jf.add(patnametxt);
		jf.add(patphtxt);
		jf.add(patprobtxt);
		jf.add(patagetxt);
		
		jf.add(jsp);

		
		
		jf.add(patidlab);
		jf.add(patnamelab);
		jf.add(patphlab);
		jf.add(pataddrlab);
		jf.add(patproblab);
		jf.add(patagelab);
		jf.add(imglab);
		jf.add(headlab);
		
		
		
	    jf.add(malerb);
	    jf.add(femalerb);

	    
		jf.add(savebt);	
		jf.add(browsesnap);
		jf.add(medbt);
		jf.add(foodbt);
		
		savebt.addActionListener(this);
		//viewbt.addActionListener(this);
		browsesnap.addActionListener(this);
		medbt.addActionListener(this);
		foodbt.addActionListener(this);
		//**** Frame Behavior
		
		jf.add(backpiclab);
		jf.setVisible(true);
		jf.setSize(680,720);
		jf.setLocation(350,10);
		jf.setResizable(false);

		
	}//Show Admission Frame End
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==browsesnap)
		{
			JFileChooser jfc=new JFileChooser();
			int k=jfc.showOpenDialog(jf);
			if(JFileChooser.APPROVE_OPTION==k)
			{
				picpath=jfc.getSelectedFile().getAbsolutePath();
				imglab.setIcon(new ImageIcon(picpath));
			}	
		}

		else if(ae.getSource()==savebt)
		{
			boolean flag=true;
			String name=null;
			int  id=0;
			
			String ph=patphtxt.getText();
			String addr=pataddrtxt.getText();
			String prob=patprobtxt.getText();
			String age=patagetxt.getText();
			if(patnametxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name Required","Admin",0);
				flag=false;
			}
			else
			{
				name=patnametxt.getText();
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
			String gender=null;
			if(malerb.isSelected())
				gender="Male";
			else if(femalerb.isSelected())
				gender="Female";
			
			
			//File Class is used to represent a physical file path on Secondary Storage

			
			if(flag==true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into addpattab values(?,?,?,?,?,?,?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,ph);
				pstmt.setString(4,addr);
				pstmt.setString(5,prob);
				pstmt.setString(6,age);
				pstmt.setString(7,gender);
				
				File picfile = new File(picpath);
				FileInputStream picfis = new FileInputStream(picfile);
				pstmt.setBinaryStream(8, picfis, (int) picfile.length());
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saved Successfully","Admin",1);
				patidtxt.setText(null);
				patnametxt.setText(null);
				patphtxt.setText(null);
				pataddrtxt.setText(null);
				patprobtxt.setText(null);
				patagetxt.setText(null);
				
				
				
				
				
				
			}
			catch(Exception e)	{	}}
		}
		else if(ae.getSource()==foodbt)
		{
			foodpres f=new foodpres();
			f.foodpresFrame();
		}
		else if(ae.getSource()==medbt)
		{
			medpres f=new medpres();
			f.medpresFrame();
		}
		
	}
	
}//Class End
