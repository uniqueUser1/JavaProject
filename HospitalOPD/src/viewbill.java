import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class viewbill implements MouseListener
{
	JFrame myframe; 
	Font myfont,f;
	
	JLabel back,viewlab,printlab,patidlab,patnamelab;
	JTextField patidtxt,patnametxt;
	JTable doctable;
	//JButton viewbt;
	JScrollPane doctablescroll;
	String headings[]={"Particulars","Details"};
	Object data[][]={
			{"Patient ID",""},
			{"Patient Name",""},
			{"Date",""},
			{"Next Appointment",""},
			{"Payment Mode",""},
			{"Bill Amount(Rs.)",""},
			{"Signature:",""}
			
	};
	void viewbillFrame()
	{
		myframe=new JFrame();
		myframe.setLayout(null);
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		
		try {
			viewlab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
		printlab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/printlab1.jpg"))));
		back=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/bill.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		patidlab=new JLabel("Patient ID:");
		patnamelab=new JLabel();
		
		
		myfont=new Font("Comic Sans MS",Font.PLAIN,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
		
		//printbt=new JButton("Print");
		//printbt.setVisible(false);
		
		viewlab.addMouseListener(this);
		printlab.addMouseListener(this);
		
		
		
		patidlab.setBounds(20,20,130,30);
		patnamelab.setBounds(330,20,130,30);
		
		patidtxt.setBounds(145,20,100,30);
		patnametxt.setBounds(490,20,130,30);

		viewlab.setBounds(290,20,100,30);
		printlab.setBounds(290,255,90,90);
		back.setBounds(0,0,420,375);
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		
		patidtxt.setFont(f);
		patnametxt.setFont(f);
		
		myframe.add(viewlab);
		myframe.add(patidlab);
		//myframe.add(patnamelab);
		myframe.add(patidtxt);
		//myframe.add(patnametxt);
		
		myframe.add(printlab);
		//doctablescroll.setOpaque(true);
		
		//printbt.addActionListener(this);
		//printbt.setBounds(50,410,150,40);
		
		//myframe.add(back);
		
		myframe.setVisible(true);
		myframe.setSize(420,375);
		myframe.setLocation(470,150);
		myframe.setResizable(false);
		
		printlab.setVisible(false);
		

		
		
	}
	@Override
public void mouseEntered(MouseEvent ae) //overriding
	
	{
		if(ae.getSource()==viewlab)
		{
			try {
				viewlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlabpic.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(ae.getSource()==printlab)
		{
			try {
				printlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/printlab2.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		
		
	}
	public void mouseExited(MouseEvent ae)
	{
		
		if(ae.getSource()==viewlab)
		{
			try {
				viewlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(ae.getSource()==printlab)
		{
			try {
				printlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/printlab1.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void mouseClicked(MouseEvent ae)
	{
		if(ae.getSource()==printlab)
		{
			try{doctable.print();}catch(Exception exp){}
		}
		

		if(ae.getSource()==viewlab)
		{
			boolean flag=true;
			int id=0;
			if(patidtxt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "ID Required","Admin",0);
				flag=false;
			}
			else
			{
				try{
				id=Integer.parseInt(patidtxt.getText());}
				catch(NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(null, "ID must be numeric","Admin",0);
					flag=false;
				}
			
			}
			Connection con=DBConnection.getDBConnection();
			if(flag==true)
			{
			try
			{
				PreparedStatement pstmt=con.prepareStatement("Select * from billtab where patid=?");
				pstmt.setInt(1,id);
				ResultSet rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					System.out.println("executed");
					
					data[0][1]=rst.getString("patid");
					data[1][1]=rst.getString("patname");
					data[2][1]=rst.getString("date");
					data[3][1]=rst.getString("nextapt");
					data[4][1]=rst.getString("pmntmd");
					data[5][1]=rst.getString("bill");
					
					doctable=new JTable(data,headings);
					doctablescroll=new JScrollPane(doctable);
					doctable.setEnabled(false);
					doctablescroll.setBounds(20,100,370,135);
					doctable.setOpaque(true);
					myframe.add(doctablescroll);
					printlab.setVisible(true);
					//doctablescroll.setVisible(true);
					
					
					
				}
				else
					JOptionPane.showMessageDialog(null,"In-Correct", "Login details", 0);
			
				
				
			}
			catch(SQLException exp)
			{
				
			}
			}
		}
	}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
}


