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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class othdocavl implements MouseListener// to be defined public when there is no main in this java file and it is linked to some other frame
{
	JFrame myframe; 
	JTable doctable;
	//JButton viewbt;
	JLabel backpiclab,viewlab;

	JScrollPane doctablescroll;
	String headings[]={"Doc ID","Doc Name","Availablity time"};
	Object data[][]=new Object[50][3];
	
	void viewdocavl()
	{
		myframe=new JFrame();
		myframe.setLayout(null);
		
		//viewbt=new JButton("View Other Doctor Details");
		try {
			backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/othdoc1pic.jpg"))));
			viewlab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}

		//printbt=new JButton("Print");
		//printbt.setVisible(false);
		
		viewlab.addMouseListener(this);
		
		//viewbt.addActionListener(this);
		//viewbt.setBounds(250,20,250,30);
		backpiclab.setBounds(0,0,500,400);
		viewlab.setBounds(130,20,250,30);

		
		myframe.add(viewlab);
		myframe.add(backpiclab);
		
		
		//printbt.addActionListener(this);
		//printbt.setBounds(50,410,150,40);
		
		//myframe.add(printbt);
		
		myframe.setVisible(true);
		myframe.setResizable(false);
		myframe.setSize(500,400);
		myframe.setLocation(425,150);
		
		
		
		
	}
	@Override
public void mouseEntered(MouseEvent me) //overriding
	
	{
		if(me.getSource()==viewlab)
		{
			try{
			viewlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlabpic.jpg"))));
			}
			catch(Exception e){}
			}
		
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==viewlab)
		{
			try{
			viewlab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/viewlab2pic.jpg"))));
			}
			catch(Exception e){}
			}
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==viewlab)
		{
			
			Connection con=DBConnection.getDBConnection();
			try
			{
				PreparedStatement pstmt=con.prepareStatement("Select * from othdocavltab");
				ResultSet rst=pstmt.executeQuery();
				int row=0;
				while(rst.next())
				{
					System.out.println("executed");
					
					data[row][0]=rst.getString("docid");
					data[row][1]=rst.getString("docname");
					data[row][2]=rst.getString("docavl");
					
					row++;
				}
				doctable=new JTable(data,headings);
				doctablescroll=new JScrollPane(doctable);
				doctable.setEnabled(false);
				doctablescroll.setBounds(20,80,450,270);
				myframe.add(doctablescroll);
				//printbt.setVisible(true);
				
			}
			catch(SQLException exp)
			{
				
			}
		}
			
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

}

