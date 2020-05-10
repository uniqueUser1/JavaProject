import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 public class foodpres implements MouseListener //implements Runnable
{
	JFrame loginframe;
	JLabel savelab,patidlab,patnamelab,mornlab,aftlab,evelab,backpiclab;
	JTextField patidtxt,patnametxt;
	Font myfont,f;
	String picpath;
	JTextArea ta1,ta2,ta3;
	JScrollPane jsp1,jsp2,jsp3;

	void foodpresFrame()
	{
		loginframe=new JFrame("Diet Prescribed");
		loginframe.setLayout(null);
		
		try{savelab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));
		backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/22.jpg"))));}
		catch(Exception e){}
		patidlab=new JLabel("Patient ID:");
		patnamelab=new JLabel("Patient Name:");
		mornlab=new JLabel("Morning:");
		aftlab=new JLabel("Afternoon:");
		evelab=new JLabel("Evening:");
		

		ta1=new JTextArea();
		jsp1=new JScrollPane(ta1);
		
		ta2=new JTextArea();
		jsp2=new JScrollPane(ta2);
		
		ta3=new JTextArea();
		jsp3=new JScrollPane(ta3);
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		/*morntxt=new JTextField();
		afttxt=new JTextField();
		evetxt=new JTextField();*/
		
		
		
		
		
		myfont=new Font("Comic Sans MS",Font.BOLD,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
	
		
		
		
		patidlab.setBounds(20,30,120,30);
		patnamelab.setBounds(280,30,150,30);
		mornlab.setBounds(20,100,100,30);
		aftlab.setBounds(250,100,150,30);
		evelab.setBounds(480,100,100,30);	
		savelab.setBounds(580,245,100,30);	

		
		
		
		patidtxt.setBounds(150,30,100,30);
		patnametxt.setBounds(440,30,200,30);
		jsp1.setBounds(20,150,200,60);
		jsp2.setBounds(250,150,200,60);
		jsp3.setBounds(480,150,200,60);

		
		
		
		backpiclab.setBounds(0,0,700,340);
		
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		mornlab.setFont(myfont);
		aftlab.setFont(myfont);
		evelab.setFont(myfont);
		
		
		patidtxt.setFont(myfont);
		patnametxt.setFont(myfont);
		ta1.setFont(f);
		ta2.setFont(f);
		ta3.setFont(f);
		
		
		
		
		
		savelab.addMouseListener(this);
		
		
		
		loginframe.add(patidlab);
		loginframe.add(patnamelab);
		loginframe.add(mornlab);
		loginframe.add(aftlab);
		loginframe.add(evelab);
		loginframe.add(savelab);
		

		
		
		loginframe.add(patidtxt);
		loginframe.add(patnametxt);
		loginframe.add(jsp1);
		loginframe.add(jsp2);
		loginframe.add(jsp3);
		
		loginframe.add(backpiclab);
		
		
		loginframe.setVisible(true);
		loginframe.setLocation(350,170);
		loginframe.setResizable(false);
		loginframe.setSize(700,340);
				
	}
	
	
	public void mouseEntered(MouseEvent me) //overriding
	
	{
		
		if(me.getSource()==savelab)
		{
			try{savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab2.jpg"))));}
			catch(Exception e){}
		
			}

		
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==savelab)
		{
			try{savelab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/savelab.jpg"))));}
			catch (Exception e) {
				
			}
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==savelab)
		{
			boolean flag=true;
			int id=0;
			String name=null;
			String morn=ta1.getText();
			String aft=ta2.getText();
			String eve=ta3.getText();
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
				id=Integer.parseInt(patidtxt.getText());
				flag=true;
			}
			
			if(flag==true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("insert into foodprestab values(?,?,?,?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,morn);
				pstmt.setString(4,aft);
				pstmt.setString(5,eve);
				
				
				
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Saved Successfully","Admin",1);
				patidtxt.setText(null);
				patnametxt.setText(null);
				ta1.setText(null);
				ta2.setText(null);
				ta3.setText(null);
				
				
				
				
				
				
				
			}
			catch(Exception e)	{	}}
		}
		}
			
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
}
	


		
		

	

