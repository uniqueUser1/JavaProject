import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class othdocdtl implements ActionListener// to be defined public when there is no main in this java file and it is linked to some other frame
{
	JFrame myframe; 
	JTable doctable;
	JButton viewbt;
	JLabel backpiclab;

	JScrollPane doctablescroll;
	String headings[]={"Doc ID","Doc Name","Contact No.","Address","Age","Experience","Qualification"};
	Object data[][]=new Object[50][7];
	void viewdocdtl()
	{
		myframe=new JFrame();
		myframe.setLayout(null);
		
		try {
			backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/othdocpic.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}viewbt=new JButton("View Other Doctor Details");
		

		//printbt=new JButton("Print");
		//printbt.setVisible(false);
		
		viewbt.addActionListener(this);
		viewbt.setBounds(280,20,180,30);
		backpiclab.setBounds(0,0,750,450);

		
		myframe.add(viewbt);
		myframe.add(backpiclab);
		
		
		//printbt.addActionListener(this);
		//printbt.setBounds(50,410,150,40);
		
		//myframe.add(printbt);
		
		myframe.setVisible(true);
		myframe.setSize(750,450);
		myframe.setLocation(325,100);
		myframe.setResizable(false);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==viewbt)
		{
			Connection con=DBConnection.getDBConnection();
			try
			{
				PreparedStatement pstmt=con.prepareStatement("Select * from othdocdtltab");
				ResultSet rst=pstmt.executeQuery();
				int row=0;
				while(rst.next())
				{
					System.out.println("executed");
					
					data[row][0]=rst.getString("docid");
					data[row][1]=rst.getString("docname");
					data[row][2]=rst.getString("docph");
					data[row][3]=rst.getString("docaddr");
					data[row][4]=rst.getString("docage");
					data[row][5]=rst.getString("docexp");
					data[row][6]=rst.getString("docqual");
					row++;
				}
				doctable=new JTable(data,headings);
				doctablescroll=new JScrollPane(doctable);
				doctable.setEnabled(false);
				doctablescroll.setBounds(25,70,690,330);
				myframe.add(doctablescroll);
				//printbt.setVisible(true);
				
			}
			catch(SQLException exp)
			{
				
			}
		}
		
	}

}


