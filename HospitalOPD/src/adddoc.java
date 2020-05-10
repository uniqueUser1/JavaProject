import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class adddoc implements MouseListener,ActionListener
{
	JFrame jf;
	JTextField docidtxt,docnametxt,docphtxt,docagetxt,docexptxt,docqualtxt;
	JLabel headlab,savelab,browsesnap,docidlab,docnamelab,docphlab,docaddrlab,docagelab,docexplab,docquallab,backpiclab,imglab;
	Font myfont,f;
	JButton addavlbt;
	JScrollPane jsp;
	
	JTextArea docaddrtxt;
	
	String picpath;
	
	public void adddocdtl()
	{
		jf=new JFrame("Add Doctor Details");
		jf.setLayout(null);
		//***** Create All Objects
		
		
		docidtxt=new JTextField();
		docnametxt=new JTextField();
		docphtxt=new JTextField();
		docagetxt=new JTextField();
		docexptxt=new JTextField();
		docqualtxt=new JTextField();
		
		docaddrtxt=new JTextArea();
		
		jsp=new JScrollPane(docaddrtxt);
		
		docidlab=new JLabel("Doctor ID:");
		docnamelab=new JLabel("Doctor Name:");
		docphlab=new JLabel("Doctor Contact:");
		docagelab=new JLabel("Doctor Age:");
		docaddrlab=new JLabel("Doctor Address:");
		docexplab=new JLabel("Doctor Experience:");
		docquallab=new JLabel("Doctor Qualification:");
		headlab=new JLabel("ADD DOCTOR'S DETAILS");

		
		addavlbt=new JButton("Add Timings");

		try{
		backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/addpatback.jpg"))));
		savelab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));
		browsesnap=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/browlab.jpg"))));}
		catch(Exception e){}

		
		imglab=new JLabel();
		
		
		
		imglab.setBorder(new LineBorder(Color.BLACK,1));//Color,Thickness
		
		

		
		
		myfont=new Font("Comic Sans MS",Font.PLAIN,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
			
		//***** Set Bounderies
		
		docidtxt.setBounds(200,80,150,30);
		docnametxt.setBounds(200,150,200,30);
		docphtxt.setBounds(200,240,150,30);
		//docaddrtxt.setBounds(180,300,200,40);
		docagetxt.setBounds(200,420,125,30);
		docexptxt.setBounds(200,510,125,30);
		docqualtxt.setBounds(200,600,200,30);

		
		jsp.setBounds(200,330,250,70);

		
		docidlab.setBounds(20,70,150,50);
		docnamelab.setBounds(20,140,150,50);
		docphlab.setBounds(20,230,150,50);
		docaddrlab.setBounds(20,320,150,50);
	    docagelab.setBounds(20,410,150,50);
		docexplab.setBounds(20,500,150,50);
		docquallab.setBounds(20,590,150,50);
	    headlab.setBounds(200,10,400,50);

		
		


		
		imglab.setBounds(500,80,120,150);
		
		
		
		savelab.setBounds(500,600,120,30);
		addavlbt.setBounds(500,500,120,30);
		
		browsesnap.setBounds(500,250,120,30);
		
		
		
		backpiclab.setBounds(0,0,1000,720);
		
		//***** Apply Font
		docidtxt.setFont(f);
		docnametxt.setFont(f);
		docphtxt.setFont(f);
		docaddrtxt.setFont(f);
		docagetxt.setFont(f);
		docexptxt.setFont(f);
		docqualtxt.setFont(f);
		
		
		
		docidlab.setFont(myfont);
		docnamelab.setFont(myfont);
		docphlab.setFont(myfont);
		docaddrlab.setFont(myfont);
		docagelab.setFont(myfont);
		docexplab.setFont(myfont);
		docquallab.setFont(myfont);
		headlab.setFont(myfont);

		headlab.setForeground(Color.RED);
		
		addavlbt.setForeground(Color.BLUE);
		
		addavlbt.setFont(f);
		
		imglab.setOpaque(true);
		
		
		
		
		//***** Add all to frame
		jf.add(docidtxt);
		jf.add(docnametxt);
		jf.add(docphtxt);
		jf.add(docagetxt);
		jf.add(docexptxt);
		jf.add(docqualtxt);
		
		jf.add(jsp);

		
		
		jf.add(docidlab);
		jf.add(docnamelab);
		jf.add(docphlab);
		jf.add(docaddrlab);
		jf.add(docagelab);
		jf.add(docexplab);
		jf.add(docquallab);
		jf.add(imglab);
		jf.add(savelab);
		jf.add(headlab);

		jf.add(browsesnap);
		
		jf.add(addavlbt);
		
		jf.add(backpiclab);
		
		
	    
		savelab.addMouseListener(this);
		//viewbt.addActionListener(this);
		browsesnap.addMouseListener(this);
		addavlbt.addActionListener(this);
		
		//**** Frame Behavior
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(680,720);
		jf.setLocation(350,10);
		//jf.setUndecorated(true);
		
	}//Show Admission Frame End
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addavlbt)
		{
			timing a=new timing();
			a.adddocavl();
		}
	}
	
	public void mouseEntered(MouseEvent ae) //overriding
	
	{
		if(ae.getSource()==savelab)
		{
			try{
			savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab2.jpg"))));
			}
			catch(Exception e){}
			}
		
		if(ae.getSource()==browsesnap)
		{
			try{browsesnap.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/browlab2.jpg"))));}catch(Exception e){}
		}

		
		
	}
	public void mouseExited(MouseEvent ae)
	{
		
		if(ae.getSource()==savelab)
		{
			try{savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));}catch(Exception e){}
		}
		
		if(ae.getSource()==browsesnap)
		{
			try{browsesnap.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/browlab.jpg"))));}catch(Exception e){}
		}

		
	}
	
	public void mouseClicked(MouseEvent ae)
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

		if(ae.getSource()==savelab)
		{
			boolean flag=true;
			String name=null;
			int  id=0;
			
			String ph=docphtxt.getText();
			String addr=docaddrtxt.getText();
			String exp=docexptxt.getText();
			String age=docagetxt.getText();
			String qual=docqualtxt.getText();
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
				try{id=Integer.parseInt(docidtxt.getText());}
				catch(NumberFormatException e){}
			}
			
			if(flag==true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into othdocdtltab values(?,?,?,?,?,?,?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,ph);
				pstmt.setString(4,addr);
				pstmt.setString(5,age);
				pstmt.setString(6,exp);
				pstmt.setString(7,qual);
				
				File picfile = new File(picpath);
				FileInputStream picfis = new FileInputStream(picfile);
				pstmt.setBinaryStream(8, picfis, (int) picfile.length());
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saved Successfully","Admin",1);
				docidtxt.setText(null);
				docnametxt.setText(null);
				docphtxt.setText(null);
				docaddrtxt.setText(null);
				docexptxt.setText(null);
				docagetxt.setText(null);
				docqualtxt.setText(null);
				
				
				
				
				
				
			}
			catch(Exception e)	{	}
		}
		}
	}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		
		
	
}//Class End









