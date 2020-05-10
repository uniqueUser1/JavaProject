import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class menuframe implements ActionListener
{
	JFrame jf;
	JMenu doc,pat,pres,bill;
	JMenuBar menubar;
	JMenuItem viewbill,spldoc,adddoc,othdoc,avldoc,dtldoc,addpat,viewpat,prefd,premed,billmi;
	Font f;
	JLabel backpic;
	JButton closebt;
	
	void showMyFrame()
	{
		jf=new JFrame("Hospice Care Menu");
		jf.setLayout(null);
		spldoc=new JMenuItem("Specialized Doctors");
		adddoc=new JMenuItem("Add Doctors");
		othdoc=new JMenu("Other doctors");
		avldoc=new JMenuItem("Doctor Availability");
		dtldoc=new JMenuItem("Doctor Detail");
		addpat=new JMenuItem("Add Patient");
		viewpat=new JMenuItem("View Patient");
		prefd=new JMenuItem("Prescribed Food");
		premed=new JMenuItem("Prescribed Medicine");
		billmi=new JMenuItem("Billing Amount");
		viewbill=new JMenuItem("View And Print");
		
		doc=new JMenu("Doctor ");
		pat=new JMenu("OPD Patient ");
		pres=new JMenu("Prescription ");
		bill=new JMenu("Bill");
		
		
		
		try{backpic=new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/menupic.jpg"))));}catch(Exception e){}
		
		closebt=new JButton("Exit");
		
		jf.add(closebt);
		
		
		doc.add(spldoc);
		doc.add(othdoc);
		
		doc.addSeparator();
		doc.add(adddoc);
		othdoc.add(dtldoc);
		othdoc.add(avldoc);
		
		pat.add(addpat);
		pat.add(viewpat);
		
		pres.add(prefd);
		pres.add(premed);
		
		bill.add(billmi);
		bill.add(viewbill);
		jf.add(backpic);
		
		f=new Font("Arial",Font.BOLD,16);
		
		spldoc.addActionListener(this);
		dtldoc.addActionListener(this);
		avldoc.addActionListener(this);
		adddoc.addActionListener(this);
		addpat.addActionListener(this);
		viewpat.addActionListener(this);
		prefd.addActionListener(this);
		premed.addActionListener(this);
		billmi.addActionListener(this);
		viewbill.addActionListener(this);
		closebt.addActionListener(this);

		
		menubar=new JMenuBar();
		menubar.add(doc);
		menubar.add(pat);
		menubar.add(pres);
		menubar.add(bill);
		
		backpic.setBounds(0,0,1100,650);
		closebt.setBounds(970,550,100,30);
		
		doc.setFont(f);
		pat.setFont(f);
		pres.setFont(f);
		bill.setFont(f);
		spldoc.setFont(f);
		othdoc.setFont(f);
		adddoc.setFont(f);
		avldoc.setFont(f);
		dtldoc.setFont(f);
		addpat.setFont(f);
		viewpat.setFont(f);
		prefd.setFont(f);
		premed.setFont(f);
		billmi.setFont(f);
		closebt.setFont(f);
		viewbill.setFont(f);
		
		
		jf.setJMenuBar(menubar);
		jf.setResizable(false);

		jf.setVisible(true);
		jf.setSize(1100,650);
		jf.setLocation(150,40);
		
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==closebt)
		{
			
			try
			{
				System.exit(0);
				
			}
			catch(Exception exp)
			{
				
			}
		}
		
		if(e.getSource()==spldoc)
		{
			
			try
			{
				spldoctor s=new spldoctor();
				s.showspldoc();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==dtldoc)
		{
			
			try
			{
				othdocdtl s=new othdocdtl();
				s.viewdocdtl();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==avldoc)
		{
			
			try
			{
				othdocavl s=new othdocavl();
				s.viewdocavl();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==adddoc)
		{
			
			try
			{
				adddoc s=new adddoc();
				s.adddocdtl();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==addpat)
		{
			
			try
			{
				addpat s=new addpat();
				s.addpatdtl();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==viewpat)
		{
			
			try
			{
				viewpat s=new viewpat();
				s.viewpatdtl();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==prefd)
		{
			
			try
			{
				viewfood s=new viewfood();
				s.viewfoodFrame();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==premed)
		{
			
			try
			{
				viewmed s=new viewmed();
				s.viewmedFrame();
			}
			catch(Exception exp)
			{
				
			}
		}
		if(e.getSource()==billmi)
		{
			
			
			try
			{
				bill s=new bill();
				s.addbilldtl();
			}
			catch(Exception exp)
			{
				
			}
		}
		
		if(e.getSource()==viewbill)
		{
			
			
			try
			{
				viewbill s=new viewbill();
				s.viewbillFrame();
			}
			catch(Exception exp)
			{
				
			}
		}
		
	}
}



