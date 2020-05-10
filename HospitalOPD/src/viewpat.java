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
public class viewpat implements ActionListener
{
	JFrame jf;
	JTextField patidtxt,patnametxt,patphtxt,patprobtxt,patagetxt,gendertxt;
	JLabel headlab,patidlab,patnamelab,patphlab,pataddrlab,patproblab,patagelab,backpiclab,imglab,genderlab;
	JButton viewbt;
	Font myfont,f;
	
	
	JScrollPane jsp;
	JTextArea pataddrtxt;
	
	String picpath;
	
	public void viewpatdtl()
	{
		jf=new JFrame("Patient Details");
		jf.setLayout(null);
		//***** Create All Objects
		
		
		patidtxt=new JTextField();
		patnametxt=new JTextField();
		patphtxt=new JTextField();
		patagetxt=new JTextField();
		patprobtxt=new JTextField();
		gendertxt=new JTextField();
		
		pataddrtxt=new JTextArea();
		
		jsp=new JScrollPane(pataddrtxt);
		
		patidlab=new JLabel("Patient ID");
		patnamelab=new JLabel("Patient Name");
		patphlab=new JLabel("Patient contact");
		patagelab=new JLabel("Patient age");
		pataddrlab=new JLabel("Patient address");
		patproblab=new JLabel("Patient problem");
		genderlab=new JLabel("Gender");
		headlab=new JLabel("View Patient Details");
		imglab=new JLabel();
		try {
			backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/3.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//printlab=new JLabel(new ImageIcon("images/printlab.jpg"));

		
		
		
		
		
		
		
		

		
		imglab.setBorder(new LineBorder(Color.BLACK,1));//Color,Thickness
		
		viewbt=new JButton("View");
		
		
		myfont=new Font("Comic Sans MS",Font.BOLD,20);
		f=new Font("Comic Sans MS",Font.PLAIN,15);
			
		//***** Set Bounderies
		
		patidtxt.setBounds(180,80,150,30);
		patnametxt.setBounds(180,150,200,30);
		patphtxt.setBounds(180,240,150,30);
		patprobtxt.setBounds(180,420,250,30);
		patagetxt.setBounds(180,510,150,30);
		gendertxt.setBounds(180,600,150,30);
		
		patidlab.setBounds(20,70,150,50);
		patnamelab.setBounds(20,140,150,50);
		patphlab.setBounds(20,230,150,50);
		pataddrlab.setBounds(20,320,150,50);
	    patproblab.setBounds(20,410,150,50);
		patagelab.setBounds(20,500,150,50);
		genderlab.setBounds(20,590,150,50);
		headlab.setBounds(190,15,200,50);
		
		//printlab.setBounds(20,470,150,50);

		
		jsp.setBounds(180,330,200,40);

		
		imglab.setBounds(500,70,120,150);
		imglab.setOpaque(true);
		
		
		
		
		viewbt.setBounds(500,600,120,30);
		
		
		
		
		
		backpiclab.setBounds(0,0,660,720);
		
		//***** Apply Font
		patidtxt.setFont(f);
		patnametxt.setFont(f);
		patphtxt.setFont(f);
		//pataddrtxt.setFont(myfont);
		patprobtxt.setFont(f);
		patagetxt.setFont(f);
		gendertxt.setFont(f);
		
		
		
		patidlab.setFont(myfont);
		patnamelab.setFont(myfont);
		patphlab.setFont(myfont);
		pataddrlab.setFont(myfont);
		patproblab.setFont(myfont);
		patagelab.setFont(myfont);
		genderlab.setFont(myfont);
        headlab.setFont(myfont);
		
        headlab.setForeground(Color.RED);
		
		viewbt.setFont(f);
	
				
		
		
		//***** Add all to frame
		jf.add(patidtxt);
		jf.add(patnametxt);
		jf.add(patphtxt);
		jf.add(patprobtxt);
		jf.add(patagetxt);
		jf.add(gendertxt);
		
		jf.add(jsp);

		
		
		jf.add(patidlab);
		jf.add(patnamelab);
		jf.add(patphlab);
		jf.add(pataddrlab);
		jf.add(patproblab);
		jf.add(patagelab);
		jf.add(imglab);
		jf.add(genderlab);
		jf.add(headlab);
		
	
		
		
	   

	    
		jf.add(viewbt);	
		
		
		jf.add(backpiclab);
		
		
		viewbt.addActionListener(this);
		
		
		//**** Frame Behavior
		
		
		jf.setVisible(true);
		jf.setSize(660,720);
		jf.setLocation(400,10);
		
	}//Show Admission Frame End
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==viewbt)
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
			if(flag==true)
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DBConnection.getDBConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from addpattab where patid=?");
				pstmt.setInt(1,id);
				ResultSet rst=pstmt.executeQuery();
				if(rst.next())
				{
					patnametxt.setText(rst.getString("patname"));
					patphtxt.setText(rst.getString("patcont"));
					pataddrtxt.setText(rst.getString("pataddr"));
					patprobtxt.setText(rst.getString("patprob"));
					patagetxt.setText(rst.getString("patage"));
					gendertxt.setText(rst.getString("gender"));
					
					Blob aBlob = rst.getBlob("image");
					byte[] imageByte = aBlob.getBytes(1, (int) aBlob.length());
                    InputStream is=new ByteArrayInputStream(imageByte);
                    BufferedImage imag=ImageIO.read(is);
                    Image image = imag;
                    imglab.setIcon(new ImageIcon(image));
				}
				else
					JOptionPane.showMessageDialog(null,"In-Correct Patient ID", "Admin", 0);
			}
			catch(Exception e)	{e.printStackTrace();	}
			}
		}
	}
	
}//Class End