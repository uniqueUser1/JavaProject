import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class spldoctor implements MouseListener //implements Runnable
{
	JFrame loginframe;
	JLabel adddoclab,backpiclab,doc1lab,doc2lab,doc3lab,doc4lab,doc5lab,pic1lab,pic2lab,pic3lab,pic4lab,pic5lab;
	
	
	Font myfont,f;
	
	
	void showspldoc()
	{
		loginframe=new JFrame("Specialized Doctors");
		loginframe.setLayout(null);
		
		doc1lab=new JLabel("Dr. Raman Kumar");
		doc2lab=new JLabel("Dr. Satish Sharma");
		doc3lab=new JLabel("Dr. Meera Dutta");
		doc4lab=new JLabel("Dr. Sahil Gupta");
		doc5lab=new JLabel("Dr. Indu Kumari");
		try {
			pic1lab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/pic1lab.jpg"))));
		pic2lab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/pic2lab.jpg"))));
		pic3lab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/pic3lab.jpg"))));
		pic4lab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/pic4lab.jpg"))));
		pic5lab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/pic5lab.jpg"))));
		adddoclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/adddocspl.jpg"))));
		backpiclab=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/spldocback.jpg"))));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
				
		
		myfont=new Font("Arial",Font.BOLD,22);
		f=new Font("Arial",Font.BOLD,15);

		
		
		doc1lab.setBounds(20,30,200,30);
		doc2lab.setBounds(20,180,200,30);
		doc3lab.setBounds(20,370,200,30);
		doc4lab.setBounds(500,30,200,30);
		doc5lab.setBounds(500,180,200,30);
		pic1lab.setBounds(350,20,100,100);
		pic2lab.setBounds(350,170,100,100);
		pic3lab.setBounds(350,360,100,100);
		pic4lab.setBounds(830,20,100,100);
		pic5lab.setBounds(830,170,100,100);
		adddoclab.setBounds(800,400,77,77);
		backpiclab.setBounds(0,0,1000,500);



		
		
		doc1lab.setFont(myfont);
		doc2lab.setFont(myfont);
		doc3lab.setFont(myfont);
		doc4lab.setFont(myfont);
		doc5lab.setFont(myfont);

		
		
		
		//headlab.setForeground(new Color(19,126,206));
		
		
		
		adddoclab.addMouseListener(this);
		doc1lab.addMouseListener(this);
		doc2lab.addMouseListener(this);
		doc3lab.addMouseListener(this);
		doc4lab.addMouseListener(this);
		doc5lab.addMouseListener(this);
		
		
		
		loginframe.add(doc1lab);
		loginframe.add(doc2lab);
		loginframe.add(doc3lab);
		loginframe.add(doc4lab);
		loginframe.add(doc5lab);
		loginframe.add(pic1lab);
		loginframe.add(pic2lab);
		loginframe.add(pic3lab);
		loginframe.add(pic4lab);
		loginframe.add(pic5lab);
		loginframe.add(adddoclab);
		loginframe.add(backpiclab);
		

		
		
		
		loginframe.setVisible(true);
		loginframe.setLocation(210,120);
		loginframe.setResizable(false);
		loginframe.setSize(1000,535);
		//f=new Font("Arial",Font.BOLD,40);
		
		
		
		//curtime=new JLabel("");curtime.setFont(f);
		
		
		//curtime.setBounds(890,100,200,40);
		
		
		//loginframe.add(curtime);
		
		
		//Thread t=new Thread(this);
		//t.start();// start method internally calls run
		
	}
	public void mouseEntered(MouseEvent me) //overriding
	
	{
		if(me.getSource()==doc1lab)
		{
			doc1lab.setForeground(Color.BLUE);
		}
		
		else if(me.getSource()==doc2lab)
		{
			doc2lab.setForeground(Color.BLUE);
		}
		
		else if(me.getSource()==doc3lab)
		{
			doc3lab.setForeground(Color.BLUE);
		}
		
		else if(me.getSource()==doc4lab)
		{
			doc4lab.setForeground(Color.BLUE);
		}
		
		else if(me.getSource()==doc5lab)
		{
			doc5lab.setForeground(Color.BLUE);
		}
		else if(me.getSource()==adddoclab)
		{
			try {adddoclab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/adddocspl2.jpg"))));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	public void mouseExited(MouseEvent me)
	{
		
		if(me.getSource()==doc1lab)
		{
			doc1lab.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==doc2lab)
		{
			doc2lab.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==doc3lab)
		{
			doc3lab.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==doc4lab)
		{
			doc4lab.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==doc5lab)
		{
			doc5lab.setForeground(Color.BLACK);
		}
		else if(me.getSource()==adddoclab)
		{
			try {
				adddoclab.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/adddocspl.jpg"))));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==doc1lab)
		{
			try
			{
				
				spldocdtl1 d=new spldocdtl1();
				d.viewdocdtl();
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}
		if(me.getSource()==doc2lab)
		{
			try
			{
				
				spldocdtl2 d=new spldocdtl2();
				d.viewdocdtl();
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}
		if(me.getSource()==doc3lab)
		{
			try
			{
				
				spldocdtl3 d=new spldocdtl3();
				d.viewdocdtl();
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}if(me.getSource()==doc4lab)
		{
			try
			{
				
				spldocdtl4 d=new spldocdtl4();
				d.viewdocdtl();
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}
		if(me.getSource()==doc5lab)
		{
			try
			{
				
				spldocdtl5 d=new spldocdtl5();
				d.viewdocdtl();
			}
			catch(Exception e)
			{
			System.out.println("Exception Occur  : "+e);	
			}
		}
		if(me.getSource()==adddoclab)
		{
			adddoc a=new adddoc();
			a.adddocdtl();
		}
		
			
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
}


	
		
		

	

