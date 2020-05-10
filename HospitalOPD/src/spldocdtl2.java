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


public class spldocdtl2 implements ActionListener
{
	JFrame myframe; 
	JLabel back;
	JTable doctable;
	JButton viewbt;
	JScrollPane doctablescroll;
	String headings[]={"Doc ID","Doc Name","Qualifications","specialisation","timings"};
	Object data[][]=new Object[1][5];
	void viewdocdtl()
	{
		myframe=new JFrame();
		myframe.setLayout(null);
		try {
			back=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/88.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		viewbt=new JButton("View Details");
		//printbt=new JButton("Print");
		//printbt.setVisible(false);
		
		viewbt.addActionListener(this);
		viewbt.setBounds(170,20,130,30);
		back.setBounds(0,0,500,200);

		myframe.add(viewbt);
		myframe.add(back);
		
		
		//printbt.addActionListener(this);
		//printbt.setBounds(50,410,150,40);
		
		//myframe.add(printbt);
		
		myframe.setVisible(true);
		myframe.setSize(500,200);
		myframe.setLocation(450,250);
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
				PreparedStatement pstmt=con.prepareStatement("Select * from spldoctab where DocID=1002");
				ResultSet rst=pstmt.executeQuery();
				int row=0;
				while(rst.next())
				{
					System.out.println("executed");
					
					data[row][0]=rst.getString("DocID");
					data[row][1]=rst.getString("DocName");
					data[row][2]=rst.getString("Qualification");
					data[row][3]=rst.getString("Specialisation");
					data[row][4]=rst.getString("Timings");
					row++;
				}
				doctable=new JTable(data,headings);
				doctablescroll=new JScrollPane(doctable);
				doctable.setEnabled(true);
				doctablescroll.setBounds(20,100,450,50);
				myframe.add(doctablescroll);
				//printbt.setVisible(true);
				
			}
			catch(SQLException exp)
			{
				
			}
		}
		
	}

}
